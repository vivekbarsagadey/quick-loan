import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import { ContactComponent } from './contact.component';
import {RouterTestingModule} from '@angular/router/testing';
import { AwesomePipe } from './awesome.pipe';
describe('ContactComponent', () => {
  let component: ContactComponent;
  let fixture: ComponentFixture<ContactComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContactComponent , AwesomePipe],
      imports: [FormsModule , RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
