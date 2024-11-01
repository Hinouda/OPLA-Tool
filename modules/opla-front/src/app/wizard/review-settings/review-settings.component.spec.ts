import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewSettingsComponent } from './review-settings.component';

describe('ReviewSettingsComponent', () => {
  let component: ReviewSettingsComponent;
  let fixture: ComponentFixture<ReviewSettingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReviewSettingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
