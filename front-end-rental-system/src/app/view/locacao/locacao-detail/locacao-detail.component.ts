import { ItemLocacaoService } from './../../../service/item-locacao.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Locacao } from 'src/app/model/locacao.model';
import { ItemLocacao } from 'src/app/model/itemLocacao.model';

@Component({
  selector: 'app-locacao-detail',
  templateUrl: './locacao-detail.component.html',
  styleUrls: ['./locacao-detail.component.css']
})
export class LocacaoDetailComponent implements OnInit {

  public locacao: Locacao;
  itemLocacoes: Array<ItemLocacao>;

  constructor(
    private router : Router,
    private itemLocacaoService : ItemLocacaoService,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.locacao = new Locacao(null, null, null, null, null, null, null);
    this.locacao.id = this.activatedRoute.snapshot.params['id'];
    this.detalhar(this.locacao.id);
  }

  detalhar(id : number) {
    this.itemLocacaoService.detalhar(id).subscribe( dados => this.itemLocacoes = dados );
  }

  navigateToVoltar() {
    this.router.navigate(['../../'], { relativeTo: this.activatedRoute });   
  }
}
