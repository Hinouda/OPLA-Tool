import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewMutationOperatorsComponent } from './review-mutation-operators.component';

describe('ReviewMutationOperatorsComponent', () => {
  let component: ReviewMutationOperatorsComponent;
  let fixture: ComponentFixture<ReviewMutationOperatorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewMutationOperatorsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewMutationOperatorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
