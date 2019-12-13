import { element } from 'protractor';
import { AuthService } from './../../../service/auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ItemLocacaoService } from './../../../service/item-locacao.service';
import { MessagesService } from 'src/app/service/messages.service';
import { EquipamentoService } from './../../../service/equipamento.service';
import { Equipamento } from './../../../model/equipamento.model';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/model/cliente.model';
import { ClienteService } from 'src/app/service/cliente.service';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { FuncionarioService } from 'src/app/service/funcionario.service';
import { Funcionario } from 'src/app/model/funcionario.model';
import { Locacao } from 'src/app/model/locacao.model';
import { DateAdapter } from '@angular/material';
import { ItemLocacao } from 'src/app/model/itemLocacao.model';
import { _TdChipsMixinBase } from '@covalent/core';
import { LocacaoService } from 'src/app/service/locacao.service';

@Component({
  selector: 'app-locacao-form',
  templateUrl: './locacao-form.component.html',
  styleUrls: ['./locacao-form.component.css']
})
export class LocacaoFormComponent implements OnInit {
  /* CRIA OS ATRIBUTOS */
  public cliente: Cliente;
  public equipamento: Equipamento;
  public funcionario: Funcionario;
  public itemLocacao: ItemLocacao;
  public locacao: Locacao;
  public locacaoForm: FormGroup;

  /* CRIA OS ARRAY-LIST */
  clienteList: Array<Cliente>;
  equipamentoList: Array<Equipamento>;
  funcionarioList: Array<Funcionario>;
  itemLocacaoList: Array<ItemLocacao> = [];

  /* CONSTRUTOR DA CLASSE */
  constructor(
    private clienteService: ClienteService,
    private equipamentoService: EquipamentoService,
    private funcionarioService: FuncionarioService,
    private itemLocacaoService: ItemLocacaoService,
    private locacaoService: LocacaoService,
    private messageService: MessagesService,
    private _adapter: DateAdapter<any>,
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router : Router,
  ) { }
  
  /* METODO CHAMADO AO INICIAR A CLASSE */
  ngOnInit() {
    this.itemLocacao = new ItemLocacao(null, null, null, null, null);
    this.locacao = new Locacao(null, null, null, null, null, null, null);
    this.createFormLocacao();
    this.listarCliente();
    this.listarEquipamento();
    this.listarFuncionario();
  }

  /* METODO PARA CRIAR O FORMULARIO */
  public createFormLocacao() {
    this.locacaoForm = this.fb.group(
      {
        cliente: [null, { validators: [Validators.required], updateOn: 'select' }],
        funcionario: [null, { validators: [Validators.required], updateOn: 'select' }],
        dataLocacao: [null, { validators: [Validators.required], updateOn: 'blur' }],
        dataDevolucao: [null, { validators: [Validators.required], updateOn: 'blur' }],
        valorTotal: [null],

        equipamento: [null],
      }    
    );
    /* SETA O LOCALE DA DATA PARA USAR PADRÃO BRASILEIRO */
    this._adapter.setLocale('pt');
  }

  /* DISPLAY CLIENTE */
  displayCliente(cliente?: Cliente): string | undefined {
    return cliente ? cliente.nome : undefined;
  }

  /* DISPLAY FUNCIONARIO */
  displayFuncionario(funcionario?: Funcionario): string | undefined {
    return funcionario ? funcionario.usuario : undefined;
  }

  /* DISPLAY EQUIPAMENTO */
  displayEquipamento(equipamento?: Equipamento): string | undefined {
    return equipamento ? equipamento.descricao : undefined;
  }

  /* LISTAR CLIENTE */
  listarCliente() {
    this.clienteService.listar().subscribe(dados => this.clienteList = dados);
  }

  /* LISTAR FUNCIONARIO */
  listarFuncionario() {
    this.funcionarioService.listar().subscribe(dados => this.funcionarioList = dados);
  }

  /* LISTAR EQUIPAMENTO */
  listarEquipamento() {
    this.equipamentoService.listar().subscribe(dados => this.equipamentoList = dados);
  }

  /* SELECT CLIENTE */
  selectCliente(event: any) {
    this.locacaoForm.get("cliente").setValue(event.option.value);
  }

  /* SELECT FUNCIONARIO */
  selectFuncionario(event: any) {
    this.locacaoForm.get("funcionario").setValue(event.option.value);
  }

  /* SELECT EQUIPAMENTO */
  selectEquipamento(event: any) {
    this.locacaoForm.get("equipamento").setValue(event.option.value);
  }

  /* METODO PARA SALVAR A LOCAÇÃO */
  onSaveLocacao() {
    /* VERIFICA SE O FORMULARIO É VALIDO */
    if (this.locacaoForm.valid) {
      if (this.itemLocacaoList.length != 0) {
        /* SETA OS VALORES DA LOCAÇÃO */
        this.locacao.cliente = this.locacaoForm.get("cliente").value;
        this.locacao.funcionario = this.locacaoForm.get("funcionario").value;
        this.locacao.dataEmprestimo = this.locacaoForm.get("dataLocacao").value;
        this.locacao.dataDevolucao = this.locacaoForm.get("dataDevolucao").value;
        //this.locacao.valorTotal = 0;
        this.locacao.locacaoAtivo = true;
        /* INSERE A LOCACAO NO BANCO DE DADOS */
        this.locacaoService.cadastrar(this.locacao).subscribe(res => {
          this.locacao = res;
          /* CHAMA O METODO PARA INSERIR O ITEM LOCACAO*/
          this.onSaveItemLocacao(res);
          this.messageService.toastSuccess('Locação realizada com sucesso.');
          this.onBack();
        },
          (error: any) => {this.messageService.toastError(error.error.message)}
        );
      } else {
        this.messageService.toastWarnning('A lista de equipamentos está vazia!');
      }
    } else {
      /* MENSAGEM DE ALERTA */
      this.messageService.toastWarnning('Preencha todos os campos obrigatórios antes de salvar.');
    }  
  }

  /* METODO PARA SALVAR O ITEM LOCAÇÃO */
  onSaveItemLocacao(any : Locacao) {
    this.itemLocacaoList.forEach(element => {
      /* ADICIONA A LOCACAO AO ITEM LOCACAO */
      element.locacao = any;
      /* INSERE O ITEM LOCACAO NO BANCO DE DADOS */
      this.itemLocacaoService.cadastrar(element).subscribe(res => { this.itemLocacao = res; this.onEstoqueEquipamento() });
    });
  }

  /* METODO PARA ATUALIZAR O ESTOQUE */
  onEstoqueEquipamento() {
    this.equipamentoService.editar(this.equipamento).subscribe(res => { this.equipamento = res});
  }

  /* METODO PARA ADICIONAR EQUIPAMENTOS NA LISTA */
  addData(){
    /* PEGA O EQUIPAMENTO SELECIONADO */
    this.equipamento = this.locacaoForm.get("equipamento").value;
    /* PEGA A QUANTIDADE INFORMADA */
    var quantidade = +(<HTMLInputElement>document.getElementById("quantidade")).value;
    /* CALCULA O VALOR UNITARIO */
    var valorUnitario = this.equipamento.precoLocacao * +quantidade;
    /* CALCULA O NOVO ESTOQUE */
    let verifica = this.verificaEstoque(this.equipamento, quantidade);
    
    if(verifica) {
      /* ATRIBUI OS VALORES AO ITEM-LOCACAO */
      this.itemLocacao = new ItemLocacao(null, null, null, null, null);
      this.itemLocacao.equipamento = this.equipamento;
      this.itemLocacao.quantidade = quantidade;
      this.itemLocacao.valorUnitario = valorUnitario;

      /* VERIFICA SE EXISTE ALGUM ELEMENTO NA LISTA */
      if(this.itemLocacaoList.length == 0) {
        /* ADICIONA O EQUIPAMENTO NA LISTA */
        this.itemLocacaoList.push(this.itemLocacao);
        this.calculaEstoque(this.equipamento, quantidade, true);
        /* SOMA O VALOR TOTAL DOS EQUIPAMENTOS */
        this.somar();
      } else {
          /* VERIFICA SE O EQUIPAMENTO JÁ ESTA NA LISTA */
          if(this.itemLocacaoList.find(x => x.equipamento.id === this.itemLocacao.equipamento.id)) {
            this.messageService.toastWarnning('Este equipamento já faz parte da lista!');
          } else {
            /* ADICIONA O EQUIPAMENTO NA LISTA */
            this.itemLocacaoList.push(this.itemLocacao);
            this.calculaEstoque(this.equipamento, quantidade, true);
            /* SOMA O VALOR TOTAL DOS EQUIPAMENTOS */
            this.somar();
          }
      }
    } else {
      this.messageService.toastWarnning('A quantidade é maior que o estoque disponivel!');
    }
  }

  /* METODO PARA DELETAR UM ITEM DA LISTA */
  onDelete(il : ItemLocacao) {
    this.itemLocacaoList.forEach(element => {
      /* VERIFICA SE ELEMENTO EXISTE NA LISTA */
      if(element == il) {
        /* PEGA A POSIÇÃO DO ITEM NA LISTA */
        var index = this.itemLocacaoList.indexOf(il);
        /* REMOVE O ITEM DA LISTA */
        this.itemLocacaoList.splice(index, 1);
        /* SOMA O VALOR TOTAL DOS EQUIPAMENTOS */
        this.calculaEstoque(element.equipamento, element.quantidade, false);
        this.somar();
      }
    });
  }

  /* METODO PARA SOMAR O VALOR TOTAL DOS EQUIPAMENTOS */
  somar() {
    this.locacao.valorTotal = 0;
    /* VERIFICA SE EXISTE ALGUM ELEMENTO NA LISTA */
    if (this.itemLocacaoList.length == 0) {
      /* SETA O VALOR TOTAL COMO ZERO */
      this.locacao.valorTotal = 0;
      document.getElementById("valorTotal").innerHTML = String(this.locacao.valorTotal);;
    } else {
      this.itemLocacaoList.forEach(element => {
        /* CALCULA O VALOR TOTAL */
        this.locacao.valorTotal = this.locacao.valorTotal + element.valorUnitario;
        document.getElementById("valorTotal").innerHTML = String(this.locacao.valorTotal);;
      });
    }
  }

  /* METODO PARA VERIFICAR O ESTOQUE */
  verificaEstoque(eqpmt: Equipamento, qtdd: number) {
    let verifica: boolean;
    if(eqpmt.estoque >= qtdd) {
      verifica = true;
    } else {
      verifica = false;
    } return verifica;
  }

  /* METODO PARA CALCULAR O ESTOQUE */
  calculaEstoque(eqpmt: Equipamento, qtdd: number, acao: boolean) {
    if(acao) {
      eqpmt.estoque = eqpmt.estoque - qtdd;
    } else {
      eqpmt.estoque = eqpmt.estoque + qtdd;
    }
  }

  /* METODO PARA VOLTAR A ROTA */
  onBack() {
    this.router.navigate(['../'], { relativeTo: this.activatedRoute }); 
  }
}