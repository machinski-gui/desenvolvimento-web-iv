import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../model/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  cadastrar(cliente: Cliente){
    return this.http.post<Cliente>('http://localhost:4200/api/api/cliente/insert/', cliente);
  }

  listar() {
    return this.http.get<Cliente[]>("http://localhost:4200/api/api/cliente/list/");
  }

  detalhar(id : number) {
    return this.http.get<Cliente>("http://localhost:4200/api/api/cliente/find?id=" + id);
  }

  remover(clienteId: number){
    return this.http.get('http://localhost:4200/api/api/cliente/remove?id='+clienteId);
  }
}
