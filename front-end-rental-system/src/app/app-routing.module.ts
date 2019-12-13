import { AuthService } from './service/auth.service';
import { LoginComponent } from './view/login/login.component';
import { ClienteListComponent } from './view/cliente/cliente-list/cliente-list.component';
import { ClienteFormComponent } from './view/cliente/cliente-form/cliente-form.component';
import { ClienteSearchComponent } from './view/cliente/cliente-search/cliente-search.component';
import { IndexComponent } from './view/index/index.component';
import { EquipamentoSearchComponent } from './view/equipamento/equipamento-search/equipamento-search.component';
import { EquipamentoListComponent } from './view/equipamento/equipamento-list/equipamento-list.component';
import { EquipamentoFormComponent } from './view/equipamento/equipamento-form/equipamento-form.component';
import { EquipamentoDetailComponent } from './view/equipamento/equipamento-detail/equipamento-detail.component';
import { LocacaoSearchComponent } from './view/locacao/locacao-search/locacao-search.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocacaoListComponent } from './view/locacao/locacao-list/locacao-list.component';
import { LocacaoDetailComponent } from './view/locacao/locacao-detail/locacao-detail.component';
import { LocacaoFormComponent } from './view/locacao/locacao-form/locacao-form.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'index', component: IndexComponent, canActivate: [AuthService] },

  { path: 'cliente', component: ClienteSearchComponent, canActivate: [AuthService] },
  { path: 'cliente/cadastrar', component: ClienteFormComponent, canActivate: [AuthService] },
  { path: 'cliente/listar', component: ClienteListComponent, canActivate: [AuthService] },
  { path: 'cliente/editar/:id', component: ClienteFormComponent, canActivate: [AuthService] },

  { path: 'equipamento', component: EquipamentoSearchComponent, canActivate: [AuthService] },
  { path: 'equipamento/cadastrar', component: EquipamentoFormComponent, canActivate: [AuthService] },
  { path: 'equipamento/listar', component: EquipamentoListComponent, canActivate: [AuthService] },
  { path: 'equipamento/editar/:id', component: EquipamentoFormComponent, canActivate: [AuthService] },
  
  { path: 'locacao', component: LocacaoSearchComponent, canActivate: [AuthService] },
  { path: 'locacao/cadastrar', component: LocacaoFormComponent, canActivate: [AuthService] },
  { path: 'locacao/listar', component: LocacaoListComponent, canActivate: [AuthService] },
  { path: 'locacao/detalhar/:id', component: LocacaoDetailComponent, canActivate: [AuthService] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
