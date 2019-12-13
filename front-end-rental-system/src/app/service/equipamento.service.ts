import { Equipamento } from './../model/equipamento.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EquipamentoService {

  constructor(private http: HttpClient) { }

  cadastrar(equipamento: Equipamento){
    return this.http.post<Equipamento>('http://localhost:4200/api/api/equipamento/insert/', equipamento);
  }

  editar(equipamento: Equipamento){
    return this.http.post<Equipamento>('http://localhost:4200/api/api/equipamento/update/', equipamento);
  }

  listar() {
    return this.http.get<Equipamento[]>("http://localhost:4200/api/api/equipamento/list/");
  }

  detalhar(id : number) {
    return this.http.get<Equipamento>("http://localhost:4200/api/api/equipamento/find?id=" + id);
  }

  remover(equipamentoId: number){
    return this.http.get('http://localhost:4200/api/api/equipamento/remove?id='+equipamentoId);
  }
}
