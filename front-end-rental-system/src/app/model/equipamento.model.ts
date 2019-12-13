export class Equipamento {
        constructor (
                public id: number,
                public codigo: string,
                public descricao: string,
                public precoEquipamento: number,
                public precoLocacao: number,
                public estoque: number,
                public equipamentoAtivo: boolean,
        ) { }
}