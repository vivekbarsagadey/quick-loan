import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import {Observable} from 'rxjs';
import {UserService} from '../user.service';
import {User} from '../user';
import {ActivatedRoute, Router, Params} from '@angular/router';


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
    this.router.navigate(['/user', user.id]);
  }

  onDeleteUser(user: User) {
    this.deletedUser =  this.userService.deleteUser(user.id);
    this.loadUser();

    setTimeout(() => {
      this.deletedUser = null;
    }, 3000);

  }

  getFullName(user: User) {
    return [user.lastName , user.firstName ].join(',');
  }

}
