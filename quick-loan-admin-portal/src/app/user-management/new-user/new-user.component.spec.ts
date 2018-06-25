import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import {NewUserComponent} from './new-user.component';
import {RouterTestingModule} from '@angular/router/testing';
import {by, element} from 'protractor';
import { BrowserModule, By } from '@angular/platform-browser';


describe('NewUserComponent', () => {
  let component: NewUserComponent;
  let fixture: ComponentFixture<NewUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewUserComponent],
      imports: [FormsModule, RouterTestingModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('first name should be filled', () => {
    expect((<HTMLInputElement>document.getElementById('firstNameInput')).value = 'test').toBeTruthy();
  });
  it('last name should be filled', () => {
    expect((<HTMLInputElement>document.getElementById('lastNameInput')).value = 'test').toBeTruthy();
  });
  it('age should be filled', () => {
    expect((<HTMLInputElement>document.getElementById('ageInput')).value = '20').toBeTruthy();
  });
  it('email should be filled', () => {
    expect((<HTMLInputElement>document.getElementById('exampleInputEmail1')).value = 'test@test.com').toBeTruthy();
  });
  it('password should be filled', () => {
    expect((<HTMLInputElement>document.getElementById('exampleInputPassword')).value = 'test@12345').toBeTruthy();
  });
  it('form should be submitted', () => {
    fixture.detectChanges();
    spyOn(component, 'onSubmit');

    (<HTMLInputElement>document.getElementById('firstNameInput')).value = 'test';
    (<HTMLInputElement>document.getElementById('lastNameInput')).value = 'test';
    (<HTMLInputElement>document.getElementById('ageInput')).value = '20';
    (<HTMLInputElement>document.getElementById('exampleInputEmail1')).value = 'test@test.com';
    (<HTMLInputElement>document.getElementById('exampleInputPassword')).value = 'test@12345';
    const el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.onSubmit).toHaveBeenCalled();

  });
});
