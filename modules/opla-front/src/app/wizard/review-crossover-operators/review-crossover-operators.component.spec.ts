import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewCrossoverOperatorsComponent } from './review-crossover-operators.component';

describe('ReviewCrossoverOperatorsComponent', () => {
  let component: ReviewCrossoverOperatorsComponent;
  let fixture: ComponentFixture<ReviewCrossoverOperatorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewCrossoverOperatorsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewCrossoverOperatorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
