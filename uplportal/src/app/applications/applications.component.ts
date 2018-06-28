import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../user-management/user.service';
import {ActivatedRoute, Router, Params} from '@angular/router';
import { UrlConstants } from '../common/url-constants';

@Component({
  selector: 'app-application',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.scss']
})
export class ApplicationsComponent implements OnInit {
  users: Observable<any[]>;
  display: any;
  currentUser: any;
  userInfo: any;
  constructor(private userService: UserService, private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.display = 'none';
    fetch( UrlConstants.APPLICATION_URL , {
      method: 'get',
      mode: 'cors'
    }).then(response => {
      console.log(response);
      return response.json();
    }).then(res => {
      console.log(res);
      this.users = res;
    }).catch(err => {}
    );
  }

  openModal(id) {
    this.display = 'block';
    fetch(UrlConstants.CUSTOMER_URL + 8, {
      method: 'get',
      mode: 'cors'
    }).then(response => {
      console.log(response);
      return response.json();
    }).then(res => {
      console.log('res>>>>>>>>>>>>>>', res);
      this.userInfo = res;
    }).catch(err => {
      }
    );
  }
  onClickAcceptBtn() {
    fetch(UrlConstants.APPLICATION_URL,  {
      method: 'POST',
      mode: 'cors',
      redirect: 'follow',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then(function() { this.display = 'none'; });
  }
  onClickRejectBtn() {
    fetch(UrlConstants.APPLICATION_URL, {
      method: 'POST',
      mode: 'cors',
      redirect: 'follow',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then(function() { this.display = 'none'; });
  }
  onCloseHandled() {
    this.display = 'none';
  }

  /* getFullName(user: User) {
     return [user.lastName, user.firstName].join(',');
   }*/

}
