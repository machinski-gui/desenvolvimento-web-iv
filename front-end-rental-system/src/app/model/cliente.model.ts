import { Tipo } from './tipo.model';

export class Cliente {
    constructor (
        public id: number,
        public nome: string,
        public cpf_cnpj: string,
        public tipo: Tipo,
        public logradouro: string,
        public numero: string,
        public bairro: string,
        public municipio: string,
        public estado: string,
        public cep: string,
        public telefone: string,
        public celular: string,
        public email: string,
        public clienteAtivo: boolean,
    ) { }
}