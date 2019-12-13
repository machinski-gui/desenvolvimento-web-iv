import { Locacao } from './locacao.model';
import { Equipamento } from './equipamento.model';

export class ItemLocacao {
    constructor(
        public id: number,
        public locacao: Locacao,
        public equipamento: Equipamento,
        public quantidade: number,
        public valorUnitario: number,
    ) {  }
}