import { async, ComponentFixture, TestBed, inject } from '@angular/core/testing';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { UserManagementComponent } from './user-management.component';
import {RouterTestingModule} from '@angular/router/testing';
import { Router } from '@angular/router';
import { Location, CommonModule } from '@angular/common';
import {NewUserComponent} from './new-user/new-user.component';
import {UserListComponent} from './user-list/user-list.component';
import {By} from '@angular/platform-browser';


describe('UserManagementComponent', () => {
  let component: UserManagementComponent;
  let fixture: ComponentFixture<UserManagementComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserManagementComponent, UserListComponent, NewUserComponent  ],
      imports: [FormsModule, ReactiveFormsModule, RouterTestingModule,
        CommonModule,
        RouterTestingModule.withRoutes([
          { path: 'user', component: UserListComponent },
          { path: 'newuser', component: NewUserComponent }
        ])],
    }).compileComponents();
  }));
  beforeEach(() => {
    fixture = TestBed.createComponent(UserManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('Should create UserManagement component', () => {
    expect(component).toBeTruthy();
  });
  it('Should display user list',
    async(inject([Router, Location], (router: Router, location: Location) => {
      fixture.detectChanges();
      fixture.debugElement.query(By.css('#userLink')).nativeElement.click()
      fixture.whenStable().then(() => {
        expect(location.path()).toEqual('/user');
      });
    })));
  it('Should redirect to create new user',
    async(inject([Router, Location], (router: Router, location: Location) => {
      fixture.detectChanges();
      fixture.debugElement.query(By.css('#newuserLink')).nativeElement.click()
      fixture.whenStable().then(() => {
        expect(location.path()).toEqual('/newuser');
      });
    })));

});
