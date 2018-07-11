import { Injectable } from '@angular/core';
import {User} from './user';
import { UrlConstant } from '../util/url-constant';

const users = [];

const usersPromise = Promise.resolve(users);
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() {
    this.loadUser();
  }
  loadUser() {
    fetch(UrlConstant.API_HOST + 'user/', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        res.forEach((user) => users.push(new User(user.id, user.firstName, user.lastName, user.age, user.email, user.password)));
        console.log('usersData>>>>>>>>>>>>>>>>>>>>>', users);
      })
      .catch(error => console.log('Error:', error));
  }
  getUsers() {
    return usersPromise;
  }

  getUser(id: number | string) {
    return usersPromise.then( u => u.find(user => user.id === +id) );
  }

  addUser(user: User) {
    return new Promise((resolve, reject) => {
      user.id = users.length;
      resolve(users.push(user));
    });
  }

  deleteUser(id: number | string) {
    const index = users.findIndex(user => user.id === +id);
    return users.splice(index, 1)[0];
  }
}
