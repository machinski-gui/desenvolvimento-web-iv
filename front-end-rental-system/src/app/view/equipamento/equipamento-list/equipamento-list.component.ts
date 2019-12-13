import { MatDialog } from '@angular/material';
import { ConfirmComponent } from './../../modal/confirm/confirm.component';
import { ActivatedRoute, Router } from '@angular/router';
import { MessagesService } from './../../../service/messages.service';
import { Equipamento } from './../../../model/equipamento.model';
import { EquipamentoService } from './../../../service/equipamento.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-equipamento-list',
  templateUrl: './equipamento-list.component.html',
  styleUrls: ['./equipamento-list.component.css']
})
export class EquipamentoListComponent implements OnInit {

  equipamentoList: Array<Equipamento>;

  constructor(
    private equipamentoService: EquipamentoService,
    private messageService: MessagesService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog,
  ) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.equipamentoService.listar().subscribe( dados => this.equipamentoList = dados );
  }

  onEdit(id : number) {
    this.router.navigate(['editar/'+id], { relativeTo: this.activatedRoute });
  }

  onDelete(id : number) {
    this.equipamentoService.remover(id).subscribe( res => {
      console.log("EQUIPAMENTO DELETADO");
      this.listar();
      this.messageService.toastSuccess('Equipamento deletado com sucesso!');
    },
      (error: any) => {this.messageService.toastError("Este Equipamento está vinculado a uma Locação")}
    );
  }

  openDialog(id: number): void {
    const dialogRef = this.dialog.open(ConfirmComponent, {
      width: '300px',
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result) {
        this.onDelete(id);
      }
    });
  }

}
