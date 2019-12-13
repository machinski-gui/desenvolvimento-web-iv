import { EquipamentoService } from './../../../service/equipamento.service';
import { MessagesService } from './../../../service/messages.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Equipamento } from './../../../model/equipamento.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-equipamento-form',
  templateUrl: './equipamento-form.component.html',
  styleUrls: ['./equipamento-form.component.css']
})
export class EquipamentoFormComponent implements OnInit {

  public equipamentoForm: FormGroup;
  public equipamento: Equipamento;
  private isOnUpdate: boolean = false;

  constructor(
    private fb: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private messageService: MessagesService,
    private equipamentoService: EquipamentoService
  ) { }

  ngOnInit() {
    this.equipamento = new Equipamento(null, null, null, null, null, null, null);
    this.createFormEquipamento();
    this.equipamento.id = this.activatedRoute.snapshot.params['id'];
    if(this.equipamento.id) {
      this.onEditEquipamento();
    }
  }

  public createFormEquipamento() {
    this.equipamentoForm = this.fb.group(
      {
        codigo: [null, { validators: [Validators.required], updateOn: 'blur' }],
        descricao: [null, { validators: [Validators.required], updateOn: 'blur' }],
        precoEquipamento: [null, { validators: [Validators.required], updateOn: 'blur' }],
        precoLocacao: [null, { validators: [Validators.required], updateOn: 'blur' }],
        estoque: [null, { validators: [Validators.required], updateOn: 'blur' }],
      }    
    );
  }

  onSaveEquipamento() {
    if (this.equipamentoForm.valid) {
      this.equipamento.codigo = this.equipamentoForm.get("codigo").value;
      this.equipamento.descricao = this.equipamentoForm.get("descricao").value;
      this.equipamento.precoEquipamento = this.equipamentoForm.get("precoEquipamento").value;
      this.equipamento.precoLocacao = this.equipamentoForm.get("precoLocacao").value;
      this.equipamento.estoque = this.equipamentoForm.get("estoque").value;
      this.equipamento.equipamentoAtivo = true;

      if(this.equipamento.id == null) {
        this.equipamentoService.cadastrar(this.equipamento).subscribe(res => {
          this.equipamento = res;
          this.messageService.toastSuccess('Equipamento cadastrado com sucesso!');
          this.onBack();
        },
          (error: any) => {this.messageService.toastError(error.error.message)}
        );
      } else {
        this.equipamentoService.editar(this.equipamento).subscribe(res => {
          this.equipamento = res;
          this.isOnUpdate = true;
          this.messageService.toastSuccess('Equipamento atualizado com sucesso!');
          this.onBack();
        },
          (error: any) => {this.messageService.toastError(error.error.message)}
        );
      }
      
    } else {
      this.messageService.toastWarnning('Preencha todos os campos obrigatórios antes de salvar.');
    }
  }

  onEditEquipamento() {
    this.equipamentoService.detalhar(this.equipamento.id).subscribe(res => {
      this.equipamentoForm.get("codigo").setValue(res.codigo);
      this.equipamentoForm.get("descricao").setValue(res.descricao);
      this.equipamentoForm.get("precoEquipamento").setValue(res.precoEquipamento);
      this.equipamentoForm.get("precoLocacao").setValue(res.precoLocacao);
      this.equipamentoForm.get("estoque").setValue(res.estoque);
      this.isOnUpdate = true;
    },
      (error: any) => {this.messageService.toastError(error.error.message)}
    );
  }

  onBack() {
    if(!this.isOnUpdate) {
        this.router.navigate(['../'], { relativeTo: this.activatedRoute }); 
    } else {
      this.router.navigate(['../../'], { relativeTo: this.activatedRoute }); 
    }
  }
}
