import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  sendToServer (username: HTMLInputElement, password: HTMLInputElement) {
    console.log(`Username is ${username.value} and password is ${password.value}`);

    fetch('http://localhost:3000/api/user/authenticate', {
      method: 'POST',
      body: JSON.stringify({
        "username": username.value,
        "password": password.value
      }),
      headers:{
        'Content-Type': 'application/json'
      }
    })
      .then(res => {console.log(res);
       return res.json()})
      .then(res => console.log(res))
      .catch(error => console.log('Error:', error));
  }

}
