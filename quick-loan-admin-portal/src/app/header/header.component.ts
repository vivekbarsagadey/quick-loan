import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';

import {FormBuilder, FormGroup, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Location } from '@angular/common';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  Form: FormGroup;
  userData: String;

  @Input()  pageName: String;
  // searchData: any;
  constructor(private router: Router, private formBuilder: FormBuilder) {
    this.Form = formBuilder.group({
      'searchData': [null, Validators.required],
    });
  }
  showSearch(userData) {
    this.router.navigate(['user', {searchData: userData}]);
  }
   ngOnInit() {
  }

}
