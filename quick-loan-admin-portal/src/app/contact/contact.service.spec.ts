import { TestBed, inject } from '@angular/core/testing';

import { ContactService } from './contact.service';

describe('ContactService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ContactService]
    });
  });

  it('should be created', inject([ContactService], (service: ContactService) => {
    expect(service).toBeTruthy();
  }));

  it('should have getContact method', inject([ContactService], (service: ContactService) => {
    expect(service.getContact).toBeTruthy();
  }));
});
