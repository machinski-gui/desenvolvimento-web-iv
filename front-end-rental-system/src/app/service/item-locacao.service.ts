import { ItemLocacao } from 'src/app/model/itemLocacao.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ItemLocacaoService {

  constructor(private http: HttpClient) { }

  cadastrar(itemLocacao: ItemLocacao){
    return this.http.post<ItemLocacao>('http://localhost:4200/api/api/itemLocacao/insert/', itemLocacao);
  }

  detalhar(id : number) {
    return this.http.get<ItemLocacao[]>("http://localhost:4200/api/api/itemLocacao/detail?id=" + id);
  }
}
