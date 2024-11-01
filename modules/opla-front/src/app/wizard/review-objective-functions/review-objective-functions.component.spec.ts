import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewObjectiveFunctionsComponent } from './review-objective-functions.component';

describe('ReviewObjectiveFunctionsComponent', () => {
  let component: ReviewObjectiveFunctionsComponent;
  let fixture: ComponentFixture<ReviewObjectiveFunctionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewObjectiveFunctionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewObjectiveFunctionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
