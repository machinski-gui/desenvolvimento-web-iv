import { element } from 'protractor';
import { MessagesService } from './messages.service';
import { Usuario } from './../../../../webiv-front-angular/src/app/model/usuario';
import { Observable } from 'rxjs';
import { Funcionario } from './../model/funcionario.model';
import { Router, ActivatedRoute, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate {

  private usuarioAutenticado: boolean = false;
  funcionarioList: Array<Funcionario>;
  mostrarMenuEmitter= new EventEmitter<boolean>();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router : Router,
    private messageService: MessagesService,
  ) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ) : Observable<boolean> | boolean {
    if(this.autenticado()) {
      return true;
    } else {
      this.router.navigate([''], { relativeTo: this.activatedRoute });
      return false;
    }
  }

  fazerLogin(usuario: string, senha: string, list: Funcionario[]) {
    list.forEach(element => {
      if(usuario == element.usuario && senha == element.senha) {
        this.usuarioAutenticado = true;
        this.mostrarMenuEmitter.emit(true);
        this.router.navigate(['index'], { relativeTo: this.activatedRoute });
      } else {
      }
    });

    if(this.usuarioAutenticado == false) {
      this.messageService.toastError("Usuário e/ou senha inválidos.");
    }
  }

  autenticado() {
    return this.usuarioAutenticado;
  }
}
