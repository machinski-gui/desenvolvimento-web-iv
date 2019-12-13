import { AuthService } from './service/auth.service';
import { BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatListModule, MatCardModule, MatMenuModule, MatInputModule, MatButtonToggleModule, MatIconModule,
  MatProgressSpinnerModule, MatSelectModule, MatSlideToggleModule, MatSnackBarModule, MatToolbarModule,
  MatTabsModule, MatSidenavModule, MatTooltipModule, MatRippleModule, MatRadioModule, MatGridListModule,
  MatDatepickerModule, MatNativeDateModule, MatSliderModule, MatAutocompleteModule } from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { CovalentCommonModule, CovalentLayoutModule, CovalentMediaModule, CovalentExpansionPanelModule,
  CovalentStepsModule, CovalentLoadingModule, CovalentDialogsModule, CovalentSearchModule, CovalentPagingModule,
  CovalentNotificationsModule, CovalentMenuModule, CovalentDataTableModule, CovalentMessageModule } from '@covalent/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule} from "@angular/flex-layout";
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LocacaoListComponent } from './view/locacao/locacao-list/locacao-list.component';
import { LocacaoDetailComponent } from './view/locacao/locacao-detail/locacao-detail.component';
import { LocacaoFormComponent } from './view/locacao/locacao-form/locacao-form.component';
import { EquipamentoDetailComponent } from './view/equipamento/equipamento-detail/equipamento-detail.component';
import { EquipamentoFormComponent } from './view/equipamento/equipamento-form/equipamento-form.component';
import { EquipamentoListComponent } from './view/equipamento/equipamento-list/equipamento-list.component';
import { EquipamentoSearchComponent } from './view/equipamento/equipamento-search/equipamento-search.component';
import { LocacaoSearchComponent } from './view/locacao/locacao-search/locacao-search.component';
import { MenuComponent } from './view/menu/menu.component';
import { IndexComponent } from './view/index/index.component';
import { ClienteDetailComponent } from './view/cliente/cliente-detail/cliente-detail.component';
import { ClienteFormComponent } from './view/cliente/cliente-form/cliente-form.component';
import { ClienteListComponent } from './view/cliente/cliente-list/cliente-list.component';
import { ClienteSearchComponent } from './view/cliente/cliente-search/cliente-search.component';
import { LoginComponent } from './view/login/login.component';
import { TextMaskModule } from 'angular2-text-mask';
import { ConfirmComponent } from './view/modal/confirm/confirm.component';
import { DevolucaoComponent } from './view/modal/devolucao/devolucao.component';
import { ExitComponent } from './view/modal/exit/exit.component';

@NgModule({
  declarations: [
    AppComponent,
    LocacaoListComponent,
    LocacaoDetailComponent,
    LocacaoFormComponent,
    EquipamentoDetailComponent,
    EquipamentoFormComponent,
    EquipamentoListComponent,
    EquipamentoSearchComponent,
    LocacaoSearchComponent,
    MenuComponent,
    IndexComponent,
    ClienteDetailComponent,
    ClienteFormComponent,
    ClienteListComponent,
    ClienteSearchComponent,
    LoginComponent,
    ConfirmComponent,
    DevolucaoComponent,
    ExitComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    
    /** Material Modules */
    
    MatButtonModule,
    MatListModule,
    MatIconModule,
    MatCardModule,
    MatMenuModule,
    MatInputModule,
    MatSelectModule,
    MatButtonToggleModule,
    MatSlideToggleModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatTabsModule,
    MatSidenavModule,
    MatTooltipModule,
    MatRippleModule,
    MatRadioModule,
    MatGridListModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSliderModule,
    MatAutocompleteModule,
    /** Covalent Modules */
    CovalentCommonModule,
    CovalentLayoutModule,
    CovalentMediaModule,
    CovalentExpansionPanelModule,
    CovalentStepsModule,
    CovalentDialogsModule,
    CovalentLoadingModule,
    CovalentSearchModule,
    CovalentPagingModule,
    CovalentNotificationsModule,
    CovalentMenuModule,
    CovalentDataTableModule,
    CovalentMessageModule,
    TextMaskModule

  ],
  providers: [
    AuthService
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    ConfirmComponent,
    DevolucaoComponent,
    ExitComponent
  ]
})
export class AppModule { }
