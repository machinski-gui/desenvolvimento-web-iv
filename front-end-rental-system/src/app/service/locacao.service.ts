import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Locacao } from '../model/locacao.model';

@Injectable({
  providedIn: 'root'
})
export class LocacaoService {

  constructor(private http: HttpClient) { }

  cadastrar(locacao: Locacao){
    return this.http.post<Locacao>('http://localhost:4200/api/api/locacao/insert/', locacao);
  }

  listar() {
    return this.http.get<Locacao[]>("http://localhost:4200/api/api/locacao/list/");
  }

  listarInativos() {
    return this.http.get<Locacao[]>("http://localhost:4200/api/api/locacao/listInactive/");
  }

  inativar(locacao: Locacao){
    return this.http.post<Locacao>('http://localhost:4200/api/api/locacao/inactivate/', locacao);
  }
}
