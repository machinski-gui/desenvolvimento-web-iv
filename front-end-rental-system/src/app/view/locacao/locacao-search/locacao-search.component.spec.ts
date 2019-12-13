import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocacaoSearchComponent } from './locacao-search.component';

describe('LocacaoSearchComponent', () => {
  let component: LocacaoSearchComponent;
  let fixture: ComponentFixture<LocacaoSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocacaoSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocacaoSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
