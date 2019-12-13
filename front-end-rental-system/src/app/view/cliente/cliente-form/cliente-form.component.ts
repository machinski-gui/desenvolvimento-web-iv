import { ExitComponent } from './../../modal/exit/exit.component';
import { MatDialog } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { MessagesService } from 'src/app/service/messages.service';
import { Cliente } from 'src/app/model/cliente.model';
import { ClienteService } from 'src/app/service/cliente.service';
import { TipoValues } from './../../../model/tipo.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {
  public myCpfCnpj = ''
  public myTelefone = ''
  public myCelular = ''
  public myCep = ''
  public maskCpfCnpj = [/[1-9]/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '-', /\d/, /\d/]
  public maskTelefone = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]
  public maskCelular = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/]
  public maskCep = [/[1-9]/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/]

  public clienteForm: FormGroup;
  public cliente: Cliente;
  private tipoList: string[] = TipoValues;
  private isOnUpdate: boolean = false;

  constructor(
    private fb: FormBuilder,
    private clienteService: ClienteService,
    private messageService: MessagesService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    this.createFormCliente();
    this.cliente.id = this.activatedRoute.snapshot.params['id'];
    if(this.cliente.id) {
      this.onEditCliente();
    }
  }
  
  createFormCliente() {
    this.clienteForm = this.fb.group({
      nome: [null, { validators: [Validators.required], updateOn: 'blur' }],
      cpf_cnpj: [null, { validators: [Validators.required], updateOn: 'blur' }],
      tipo: [null, { validators: [Validators.required], updateOn: 'blur' }],
      telefone: [null, { validators: [Validators.required], updateOn: 'blur' }],
      celular: [null, { validators: [Validators.required], updateOn: 'blur' }],
      email: [null, { validators: [Validators.required, Validators.email], updateOn: 'blur' }],
      logradouro: [null, { validators: [Validators.required], updateOn: 'blur' }],
      numero: [null, { validators: [Validators.required], updateOn: 'blur' }],
      bairro: [null, { validators: [Validators.required], updateOn: 'blur' }],
      cidade: [null, { validators: [Validators.required], updateOn: 'blur' }],
      estado: [null, { validators: [Validators.required], updateOn: 'blur' }],
      cep: [null, { validators: [Validators.required], updateOn: 'blur' }],
    });
  }

  onSaveCliente() {
    if (this.clienteForm.valid) {
      this.cliente.nome = this.clienteForm.get("nome").value;
      this.cliente.cpf_cnpj = this.clienteForm.get("cpf_cnpj").value;
      this.cliente.tipo = this.clienteForm.get("tipo").value;
      this.cliente.telefone = this.clienteForm.get("telefone").value;
      this.cliente.celular = this.clienteForm.get("celular").value;
      this.cliente.email = this.clienteForm.get("email").value;
      this.cliente.logradouro = this.clienteForm.get("logradouro").value;
      this.cliente.numero = this.clienteForm.get("numero").value;
      this.cliente.bairro = this.clienteForm.get("bairro").value;
      this.cliente.municipio = this.clienteForm.get("cidade").value;
      this.cliente.estado = this.clienteForm.get("estado").value;
      this.cliente.cep = this.clienteForm.get("cep").value;
      this.cliente.clienteAtivo = true;

      if(this.cliente.id == null) {
        this.clienteService.cadastrar(this.cliente).subscribe(res => {
          this.cliente = res;
          this.messageService.toastSuccess("Cliente cadastrado com sucesso!");
          this.onBack();
        },
          (erro: any) => {this.messageService.toastError("Erro ao cadastrar cliente. Verifique os dados ou contate um administrador!")}
        );
      } else {
        this.clienteService.cadastrar(this.cliente).subscribe(res => {
          this.cliente = res;
          this.isOnUpdate = true;
          this.messageService.toastSuccess("Cliente atualizado com sucesso!");
          this.onBack();
        },
          (erro: any) => {this.messageService.toastError("Erro ao atualizar cliente. Verifique os dados ou contate um administrador!")}
        );
      }
    } else {
      this.messageService.toastWarnning('Preencha todos os campos obrigatórios antes de salvar.');
    }
  }

  onEditCliente() {
    this.clienteService.detalhar(this.cliente.id).subscribe(res => {
      this.clienteForm.get("nome").setValue(res.nome);
      this.clienteForm.get("cpf_cnpj").setValue(res.cpf_cnpj);
      this.clienteForm.get("tipo").setValue(res.tipo);
      this.clienteForm.get("telefone").setValue(res.telefone);
      this.clienteForm.get("celular").setValue(res.celular);
      this.clienteForm.get("email").setValue(res.email);
      this.clienteForm.get("logradouro").setValue(res.logradouro);
      this.clienteForm.get("numero").setValue(res.numero);
      this.clienteForm.get("bairro").setValue(res.bairro);
      this.clienteForm.get("cidade").setValue(res.municipio);
      this.clienteForm.get("estado").setValue(res.estado);
      this.clienteForm.get("cep").setValue(res.cep);
      this.isOnUpdate = true;
    },
      (error: any) => {this.messageService.toastError("Erro ao atualizar cliente!")}
    );
  }

  onBack() {
    if(!this.isOnUpdate) {
      this.router.navigate(['../'], { relativeTo: this.activatedRoute }); 
    } else {
    this.router.navigate(['../../'], { relativeTo: this.activatedRoute }); 
    }
  }

  openDialog(id: number): void {
    const dialogRef = this.dialog.open(ExitComponent, {
      width: '400px',
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result) {
        this.onBack();
      }
    });
  }

  toggle() {
    if (this.clienteForm.get("tipo").value == 'FISICA') {
      console.log('FISICA');
      this.maskCpfCnpj = [/[1-9]/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '-', /\d/, /\d/]
    } else if (this.clienteForm.get("tipo").value == 'JURIDICA') {
      console.log('JURIDICA');
      this.maskCpfCnpj = [/[1-9]/, /\d/, '.', /\d/, /\d/, /\d/, '.', /\d/, /\d/, /\d/, '/', /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/]
    }
  }
}
