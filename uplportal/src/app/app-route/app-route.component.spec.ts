import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppRouteComponent } from './app-route.component';

describe('AppRouteComponent', () => {
  let component: AppRouteComponent;
  let fixture: ComponentFixture<AppRouteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppRouteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
