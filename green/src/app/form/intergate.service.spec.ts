import { TestBed } from '@angular/core/testing';

import { IntergateService } from './intergate.service';

describe('IntergateService', () => {
  let service: IntergateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IntergateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
