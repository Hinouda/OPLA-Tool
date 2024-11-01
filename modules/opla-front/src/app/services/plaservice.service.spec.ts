import { TestBed } from '@angular/core/testing';

import { PLAService } from './plaservice.service';

describe('PLAServiceService', () => {
  let service: PLAService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PLAService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
