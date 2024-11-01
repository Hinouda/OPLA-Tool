import { ComponentFixture, TestBed } from '@angular/core/testing';
import { InteractionsComponent } from './interactions.component';
import { StateService } from '../../services/state.service';
import { DialogService } from '../../services/dialog.service';
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('InteractionsComponent', () => {
  let component: InteractionsComponent;
  let fixture: ComponentFixture<InteractionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InteractionsComponent ],
      providers: [ StateService, DialogService ],
      schemas: [ NO_ERRORS_SCHEMA ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InteractionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
