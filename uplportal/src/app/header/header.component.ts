import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Store} from '@ngrx/store';
import {FormBuilder, FormGroup, Validators, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Location } from '@angular/common';
import { UrlConstant } from '../util/url-constant';
import { domainMembersUpdate } from '../api/update-service';

@Component({
  selector: '.app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  Form: FormGroup;
  userData: String;
  dataForServer;
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
  synchronize() {
    domainMembersUpdate();
   //  Store.dispatch(domainMembersUpdate()).then(data => data.json()).then( res => console.log(res)).catch(err => console.log(err))
  }
}
