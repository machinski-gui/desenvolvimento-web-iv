import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipamentoSearchComponent } from './equipamento-search.component';

describe('EquipamentoSearchComponent', () => {
  let component: EquipamentoSearchComponent;
  let fixture: ComponentFixture<EquipamentoSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipamentoSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipamentoSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
