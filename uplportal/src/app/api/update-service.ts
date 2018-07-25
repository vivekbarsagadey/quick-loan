/**
 * Created by whizit on 12-07-2018.
 */
import { UrlConstant } from '../util/url-constant';

export function getCustomerAge(data) {
  if (data) {
    return((new Date).getFullYear() - parseInt((data).substr(0, 4), 10));
  } else {
    return null;
  }
}

export function domainMembersUpdate() {
  const URL = 'user/updateUserData';
  const userData = [];
  fetch(UrlConstant.JAVA_HOST + 'customer/', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(res => res.json())
    .then(res => {
      res.forEach((data) => {
        if (data) {
          userData.push({
            firstName: data.userDetails.firstName,
            lastName: data.userDetails.lastName,
            age: getCustomerAge(data.userDetails.doB),
            email: data.contactDetails.emailId,
            password: data.contactDetails.password,
            userName: data.contactDetails.password,
            role: 'customer'
          });
        }
      });
      console.log('response from server.........', res);
      updateUserData(userData, URL);
    });
}

export function updateUserData(userData, URL) {
  const dataForServer = {
    'userData': userData
  };
  fetch(UrlConstant.API_HOST + URL, {
    method: 'POST',
    body: JSON.stringify(dataForServer),
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(res => {console.log('response>>>>>>>>>>', res['statusText']); });
}

export function createUserDataToOperate(User, URL) {
  const userData = [];
  if (User) {
    userData.push({
      firstName: User['firstName'],
      lastName: User['lastName'],
      age: User['age'],
      email: User['email'],
      password: User['password'],
      userName: User['password'],
      role: 'customer'
    });
  }
  updateUserData(userData, URL);
}

export function domainMembersAdd({User}) {
  const URL = 'user/updateUserData';
  createUserDataToOperate(User, URL);
}

export function domainMembersDelete({User}) {
  const URL = 'user/deleteUserData';
  createUserDataToOperate(User, URL);
}


