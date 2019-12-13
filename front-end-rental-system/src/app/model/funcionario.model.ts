import { Cargo } from './cargo.model';

export class Funcionario {
    constructor (
        public id: number,
        public usuario: string,
        public senha: string,
        public cargo: Cargo,
    ) { }
}