import { Component, OnInit } from '@angular/core';
import { UrlConstant } from '../util/url-constant'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  dataForServer;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  sendToServer (username: HTMLInputElement, password: HTMLInputElement) {

    this.dataForServer = {
      "username": username.value,
      "password": password.value
    };

    fetch(UrlConstant.API_HOST + 'user/authenticate', {
      method: 'POST',
      body: JSON.stringify(this.dataForServer),
      headers:{
        'Content-Type': 'application/json'
      }
    })
      .then(res => res.json())
      .then(res => {
        if(res.auth == true) {
          console.log(res);
          this.router.navigateByUrl('/home')
        }
      })
      .catch(error => console.log('Error:', error));
  }

}
