import { AuthService } from './../../service/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit() {
  }

  navigateToHome() {
    this.router.navigate(['index'], { relativeTo: this.activatedRoute });
  }

  navigateToCliente() {
    this.router.navigate(['cliente'], { relativeTo: this.activatedRoute });
  }

  navigateToEquipamento() {
    this.router.navigate(['equipamento'], { relativeTo: this.activatedRoute });
  }

  navigateToLocacao() {
    this.router.navigate(['locacao'], { relativeTo: this.activatedRoute });
  }

  navigateToExit() {
    window.location.href = "";
  }
}
