import { ConfirmComponent } from './../../modal/confirm/confirm.component';
import { ActivatedRoute, Router } from '@angular/router';
import { MessagesService } from 'src/app/service/messages.service';
import { Cliente } from 'src/app/model/cliente.model';
import { ClienteService } from 'src/app/service/cliente.service';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  clienteList: Array<Cliente>;

  constructor(
    private clienteService: ClienteService,
    private messageService: MessagesService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.clienteService.listar().subscribe(dados => this.clienteList = dados);
  }

  onEdit(id: number) {
    this.router.navigate(['editar/'+id], { relativeTo: this.activatedRoute });
  }

  onDelete(id: number) {
    this.clienteService.remover(id).subscribe(res => {
      this.messageService.toastSuccess("Cliente deletado com sucesso!");
      this.listar();
    },
    (error: any) => {this.messageService.toastError("Este Cliente está vinculado a uma Locação!")}
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
