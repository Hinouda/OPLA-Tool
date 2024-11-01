import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserirPlaJanelaComponent } from './inserir-pla-janela.component';

describe('InserirPlaJanelaComponent', () => {
  let component: InserirPlaJanelaComponent;
  let fixture: ComponentFixture<InserirPlaJanelaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InserirPlaJanelaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InserirPlaJanelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
