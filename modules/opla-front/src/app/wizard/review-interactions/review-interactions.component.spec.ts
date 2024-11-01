import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewInteractionsComponent } from './review-interactions.component';

describe('ReviewInteractionsComponent', () => {
  let component: ReviewInteractionsComponent;
  let fixture: ComponentFixture<ReviewInteractionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewInteractionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewInteractionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
