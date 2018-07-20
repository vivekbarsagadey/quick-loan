import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvestorManagementComponent } from './investor-management.component';

describe('InvestorManagementComponent', () => {
  let component: InvestorManagementComponent;
  let fixture: ComponentFixture<InvestorManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvestorManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvestorManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
