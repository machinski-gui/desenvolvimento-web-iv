import { AuthService } from './service/auth.service';
import { LoginComponent } from './view/login/login.component';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projeto-web-iv';
  mostrarMenu: boolean = false;

  constructor(
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.authService.mostrarMenuEmitter.subscribe(mostrar => this.mostrarMenu = mostrar);
  }
}
