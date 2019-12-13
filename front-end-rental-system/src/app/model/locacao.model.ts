import { Cliente } from './cliente.model';
import { Funcionario } from './funcionario.model';

export class Locacao {
    constructor (
        public id: number,
        public cliente: Cliente,
        public funcionario: Funcionario,
        public dataEmprestimo: Date,
        public dataDevolucao: Date,
        public valorTotal: number,
        public locacaoAtivo: boolean,
    ) { }
}