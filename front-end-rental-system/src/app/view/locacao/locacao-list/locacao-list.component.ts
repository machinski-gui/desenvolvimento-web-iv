import { DevolucaoComponent } from './../../modal/devolucao/devolucao.component';
import { MatDialog } from '@angular/material';
import { LocacaoSearchComponent } from './../locacao-search/locacao-search.component';
import { MessagesService } from './../../../service/messages.service';
import { Component, OnInit } from '@angular/core';
import { Locacao } from 'src/app/model/locacao.model';
import { LocacaoService } from 'src/app/service/locacao.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';

@Component({
  selector: 'app-locacao-list',
  templateUrl: './locacao-list.component.html',
  styleUrls: ['./locacao-list.component.css']
})
export class LocacaoListComponent implements OnInit {

  display = 'listview';
  locacaoList: Array<Locacao>;

  constructor(
    private locacaoService : LocacaoService,
    private router : Router,
    private messageService: MessagesService,
    private lsc: LocacaoSearchComponent,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.listar();
    var value = this.lsc.emitirValor.subscribe(value => this.toggle(value))
  }

  toggle(value){
    if (value == 1) {
      this.listar();
      this.display = 'listview';
    } else {
      this.listarInativos();
      this.display = 'none';
    }
  }

  listar() {
    this.locacaoService.listar().subscribe( dados => this.locacaoList = dados );
  }

  listarInativos() {
    this.locacaoService.listarInativos().subscribe( dados => this.locacaoList = dados );
  }

  detalhar(id: any) {
    this.router.navigate(['locacao/detalhar', id]);
  }

  inativar(l : Locacao) {
      l.locacaoAtivo = false;
      this.locacaoService.inativar(l).subscribe(res => { 
        this.messageService.toastSuccess('Devolução realizada com sucesso');
        this.listar();
      });      
  }  

  openDialog(l : Locacao): void {
    const dialogRef = this.dialog.open(DevolucaoComponent, {
      width: '400px',
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result) {
        this.inativar(l);
      }
    });
  }
}


