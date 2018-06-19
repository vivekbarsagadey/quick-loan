import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {UserService} from '../user-management/user.service';
import {ActivatedRoute, Router, Params} from '@angular/router';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss']
})
export class ApplicationComponent implements OnInit {
  users: Observable<any[]>;
  display: any;
  currentUser: any;
  userInfo: any;
  constructor(private userService: UserService, private route: ActivatedRoute,
              private router: Router) {
    // this.route.params.subscribe(params => {
    //   console.log(params);
    //   if (params['searchData']) {
    //     this.doSearch(params['searchData']);
    //   }
    // });
  }

  ngOnInit() {
     // this.loadUser();
    this.display = 'none';
    fetch('http://localhost:8080/api/applications/', {
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
    /*this.currentUser = u;*/
    this.display = 'block';
    /*$('.backdrop').css('display', 'block');
    $('.modal').css('display', 'block');*/
    fetch('http://localhost:8080/api/customer/' + 1, {
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
    fetch('http://localhost:8080/api/customer/', {
      method: 'POST',
      mode: 'cors',
      redirect: 'follow',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then(function() { /* handle response */ });
  }
  onClickRejectBtn() {
    fetch('http://localhost:8080/api/customer/', {
      method: 'POST',
      mode: 'cors',
      redirect: 'follow',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then(function() { /* handle response */ });
  }
  onCloseHandled() {
    this.display = 'none';
    /*$('.backdrop').css('display', 'none');
    $('.modal').css('display', 'none');*/
  }

 /* getFullName(user: User) {
    return [user.lastName, user.firstName].join(',');
  }*/

}
