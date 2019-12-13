import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocacaoDetailComponent } from './locacao-detail.component';

describe('LocacaoDetailComponent', () => {
  let component: LocacaoDetailComponent;
  let fixture: ComponentFixture<LocacaoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocacaoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocacaoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
