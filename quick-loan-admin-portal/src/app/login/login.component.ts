import { Component, OnInit } from '@angular/core';
import { UrlConstant } from '../util/url-constant';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  dataForServer;
  errorFieldValue;

  loginForm: FormGroup;
  submitted = false;
  constructor(private router: Router, private formBuilder: FormBuilder) {
    this.errorFieldValue = 'none';
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required, Validators.minLength(5)])],
      password: ['',  Validators.compose([Validators.required, Validators.minLength(5)])]
    });
  }
  get f() { return this.loginForm.controls; }

  sendToServerold (username: HTMLInputElement, password: HTMLInputElement) {

    this.dataForServer = {
      'username': username.value,
      'password': password.value
    };

    fetch(UrlConstant.API_HOST + 'user/authenticate', {
      method: 'POST',
      body: JSON.stringify(this.dataForServer),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(res => res.json())
      .then(res => {
        if (res.auth) {
          console.log(res);
          localStorage.setItem( 'admin', JSON.stringify(res));
          this.router.navigateByUrl('/home');
        } else {
          this.errorFieldValue = 'block';
        }
      })
      .catch(error => console.log('Error:', error));
  }

  onSubmit () {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    } else{
      fetch(UrlConstant.API_HOST + 'user/authenticate', {
        method: 'POST',
        body: JSON.stringify(this.loginForm.value),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(res => res.json())
        .then(res => {
          if (res.auth) {
            console.log(res);
            localStorage.setItem( 'admin', JSON.stringify(res));
            this.router.navigateByUrl('/home');
          } else {
            this.errorFieldValue = 'block';
          }
        })
        .catch(error => console.log('Error:', error));
    }

  }

}
