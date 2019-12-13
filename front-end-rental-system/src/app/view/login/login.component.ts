import { MessagesService } from './../../service/messages.service';
import { Funcionario } from './../../model/funcionario.model';
import { FuncionarioService } from './../../service/funcionario.service';
import { AuthService } from './../../service/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  funcionarioList: Array<Funcionario>;

  constructor(
    private authService: AuthService,
    private funcionarioService: FuncionarioService,
  ) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.funcionarioService.listar().subscribe(dados => this.funcionarioList = dados);
  }

  fazerLogin() {
    var usuario = (<HTMLInputElement>document.getElementById("usuario")).value;
    var senha = (<HTMLInputElement>document.getElementById("senha")).value;
    this.authService.fazerLogin(usuario, senha, this.funcionarioList);
  }
}