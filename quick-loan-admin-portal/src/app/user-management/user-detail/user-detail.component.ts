import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import {Observable} from 'rxjs';
import {UserService} from '../user.service';
import {User} from '../user';
import {ActivatedRoute, Router, Params} from '@angular/router';
@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.scss']
})
export class UserDetailComponent implements OnInit {
  constructor(private userService: UserService, private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    const id = +this.route.snapshot.params['id'];
    console.log('id', id);
    this.route.params.pipe(switchMap((params: Params) => this.userService.getUser(+params['id']))).subscribe((user: User) => {
      /*this.user = user;*/
    });
  }
  getFullName(user: User) {
    return [user.lastName , user.firstName ].join(', ');
  }
}
