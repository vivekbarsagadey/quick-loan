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
  users: any;
  dispalyMessage: String;
  userId: string;
  display: any;
  currentUser: any;
  userInfo: any;
  constructor(private userService: UserService, private route: ActivatedRoute,
              private router: Router) {    const userData = JSON.parse(localStorage.getItem('userData'));
    this.userId = userData.user.id;
  }

  ngOnInit() {
    this.display = 'none';
    fetch( UrlConstants.APPLICATION_BY_INVESTORID_URL, {
      method: 'get',
      mode: 'cors'
    }).then(response => {
      console.log(response);
      return response.json();
    }).then(res => {
      console.log(res);
      this.users = res;
      this.displayScreenMessage();
     // this.users = res.filter((user) => user['investorId'] === this.userId );
    }).catch(err => {}
    );
  }

  displayScreenMessage() {
    this.dispalyMessage = '';
    if (!(this.users.length)) {
      this.dispalyMessage = 'No Pending Application Requests';
    }
  }
  openModal(id) {
    this.display = 'block';
    fetch(UrlConstants.CUSTOMER_URL + id, {
      method: 'get',
      mode: 'cors'
    }).then(response => {
      console.log(response);
      return response.json();
    }).then(res => {
      console.log('res>>>>>>>>>>>>>>', res);
      this.userInfo = res;
    }).catch(err => {
      console.log('err>>>>>>>>>>>>>>', err);
      }
    );
  }
  onClickAcceptBtn(userId) {
    fetch(UrlConstants.APPLICATION_LEDGER_URL + 'updateStatus/' + userId + '/APPROVED',  {
      method: 'GET',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then((res) => console.log(res)
    );

    // then(function() { this.display = 'none'; });
  }
  onClickRejectBtn(userId) {
    fetch(UrlConstants.APPLICATION_LEDGER_URL + 'updateStatus/' + userId + '/REJECTED', {
      method: 'GET',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then((res) => console.log(res));

    // then(function() { this.display = 'none'; });
  }
  onCloseHandled() {
    this.display = 'none';
  }

  /* getFullName(user: User) {
     return [user.lastName, user.firstName].join(',');
   }*/

}
