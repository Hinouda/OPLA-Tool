import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CrossoverOperatorsComponent } from './crossover-operators.component';

describe('CrossoverOperatorComponent', () => {
  let component: CrossoverOperatorsComponent;
  let fixture: ComponentFixture<CrossoverOperatorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrossoverOperatorsComponent]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrossoverOperatorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
