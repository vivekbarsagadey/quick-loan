import { Injectable } from '@angular/core';
import {User} from './user';

const users = [];

const usersPromise = Promise.resolve(users);
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() {
    fetch('../../assets/users.json').then(res => res.json()).then(res => {
      for (let i = 0; i < res.users.length; i++) {
        const [id, firstName, lastName, age, email, password] = res.users[i];
        users.push(new User(id, firstName, lastName, age, email, password));
      }
      console.log(users);
    });
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
    })  ;
  }

  deleteUser(id: number | string) {
    const index = users.findIndex(user => user.id === +id);
    return users.splice(index, 1)[0];
  }
}
