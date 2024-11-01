import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObjectiveFunctionsJanelaComponent } from './objective-functions-janela.component';

describe('ObjectiveFunctionsJanelaComponent', () => {
  let component: ObjectiveFunctionsJanelaComponent;
  let fixture: ComponentFixture<ObjectiveFunctionsJanelaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObjectiveFunctionsJanelaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObjectiveFunctionsJanelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
