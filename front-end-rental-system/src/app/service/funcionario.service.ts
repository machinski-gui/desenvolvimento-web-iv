import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Funcionario } from '../model/funcionario.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Funcionario[]>("http://localhost:4200/api/api/funcionario/list/");
  }
}
