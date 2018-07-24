import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import {Observable} from 'rxjs';
import {UserService} from '../user.service';
import {User} from '../user';
import {ActivatedRoute, Router, Params} from '@angular/router';
import { domainMembersDelete } from '../../api/update-service';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: Observable<User[]>;
  deletedUser: User;
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
    this.loadUser();
  }


  private loadUser() {
    this.users = this.route.params.pipe(
      switchMap((params: Params) => {
        return this.userService.getUsers();
      }));
  }
  // doSearch(data) {
  //   return data;
  // }
  onSelect(user: User) {
    this.router.navigate(['uplportal/user', user.id]);
  }

  onDeleteUsers(user: User) {
    domainMembersDelete({User: user});
    this.deletedUser =  this.userService.deleteUser(user.id);
    this.loadUser();

    setTimeout(() => {
      this.deletedUser = null;
    }, 3000);

  }
  newUserComponent() {
    this.router.navigate(['uplportal/newuser']);
  }
  getFullName(user: User) {
    return [user.lastName , user.firstName ].join(',');
  }

}
