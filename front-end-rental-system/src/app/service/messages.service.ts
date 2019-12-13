import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from "@angular/material";

@Injectable({
  providedIn: 'root'
})
export class MessagesService {

  /** 
   * @param snackBarService 
   * @param translate 
  **/
  constructor( 
    public snackBarService: MatSnackBar,
  ) {  }

  /**
   * RETORNA UMA MENSAGEM DE SUCESSO PARA O USUÁRIO
   * @param message
   * @param duration
  **/
  public toastSuccess( message: string, duration = 5000 ) {
    let config = new MatSnackBarConfig();
    config.duration = duration;
    config.panelClass = ['toast-success', 'toast'];
    this.snackBarService.open( message, '', config );
  }

  /**
   * RETORNA UMA MENSAGEM DE ERRO PARA O USUÁRIO
   * @param message
   * @param duration
  **/
  public toastError( message: string, duration = 5000 ) {
    let config = new MatSnackBarConfig();
    config.duration = duration;
    config.panelClass = ['toast-error', 'toast'];
    this.snackBarService.open( message, '', config );
  }

  /**
   * RETORNA UMA MENSAGEM DE ALERTA PARA O USUÁRIO
   * @param message
   * @param duration
  **/
  public toastWarnning( message: string, duration = 5000 ) {
    let config = new MatSnackBarConfig();
    config.duration = duration;
    config.panelClass = ['toast-warnning', 'toast'];
    this.snackBarService.open( message, '', config );
  }
}
