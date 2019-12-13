import { TestBed } from '@angular/core/testing';

import { ItemLocacaoService } from './item-locacao.service';

describe('ItemLocacaoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ItemLocacaoService = TestBed.get(ItemLocacaoService);
    expect(service).toBeTruthy();
  });
});
