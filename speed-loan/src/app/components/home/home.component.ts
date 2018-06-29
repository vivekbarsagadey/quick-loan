import { Component, OnInit, Input } from '@angular/core';
import {AppComponent} from '../../app.component';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  @Input() appComponents: AppComponent;
  Form: FormGroup;
  post: any;
  email: string;
  zipCode: number;
  amount: number;
  contact: number;
  name: string;
  formDispaly = true;
  formInfo;
  constructor(private formBuilder: FormBuilder, private router: Router) {
    this.appComponents = new AppComponent();
    this.Form = formBuilder.group({
      'name': [null, Validators.required],
      'contact': [null, Validators.compose([Validators.required, Validators.minLength(10)])],
      'amount': [null, Validators.required],
      'zipCode': [null, Validators.compose([Validators.required, Validators.minLength(6)])],
      'email': [null, Validators.compose([Validators.required, Validators.email])]
    });
  }
  message = 'Enter valid input text';
  addPost(post) {
    console.log(post);
    this.formDispaly = !this.formDispaly;
    this.router.navigate(['../apply']);
  }
  ngOnInit() {
  }
  // isApplicationVisible() {
  //   this.elementService.isApplicationVisible();
  //   return false;
  // }
}
