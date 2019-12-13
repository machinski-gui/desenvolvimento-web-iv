import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-locacao-search',
  templateUrl: './locacao-search.component.html',
  styleUrls: ['./locacao-search.component.css']
})
export class LocacaoSearchComponent implements OnInit {

  emitirValor = new EventEmitter<string>();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router : Router
  ) { }

  ngOnInit() {
  } 

  navigateToNovaLocacao() {
    this.router.navigate(['cadastrar'], { relativeTo: this.activatedRoute });   
  }

  tipoLD(value) {
    this.emitirValor.emit(value);
  }
}