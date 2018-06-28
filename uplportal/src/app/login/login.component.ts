import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UrlConstant } from '../util/url-constant';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  errorFieldValue;
  dataForServer;
  constructor(private router: Router) {
    this.errorFieldValue = 'none';
  }

  ngOnInit() {
  }

  sendToServer (username: HTMLInputElement, password: HTMLInputElement) {

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
          this.router.navigateByUrl('/route');
        } else {
          this.errorFieldValue = 'block';
        }
      })
      .catch(error => console.log('Error:', error));
  }

}
