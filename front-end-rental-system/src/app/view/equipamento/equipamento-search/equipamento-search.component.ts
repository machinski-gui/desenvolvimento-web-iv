import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-equipamento-search',
  templateUrl: './equipamento-search.component.html',
  styleUrls: ['./equipamento-search.component.css']
})
export class EquipamentoSearchComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private router : Router
  ) { }

  ngOnInit() {
  }

  navigateToNovoEquipamento() {
    this.router.navigate(['cadastrar'], { relativeTo: this.activatedRoute });   
  }

}
