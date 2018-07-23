import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewInvestorComponent } from './new-investor.component';

describe('NewInvestorComponent', () => {
  let component: NewInvestorComponent;
  let fixture: ComponentFixture<NewInvestorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewInvestorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewInvestorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
