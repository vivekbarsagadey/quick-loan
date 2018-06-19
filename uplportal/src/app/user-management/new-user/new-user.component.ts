import { Component, OnInit } from '@angular/core';
import { switchMap } from 'rxjs/operators';
import {Observable} from 'rxjs';
import {UserService} from '../user.service';
import {User} from '../user';
import {ActivatedRoute, Router, Params} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {

  user: User;

  constructor(private userService: UserService, private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.user = new User(-1, null, null, null, null, null);
  }
  onSubmit() {
    this.userService.addUser(this.user).then(() => {
      this.router.navigate(['/user']);
    });

  }

}
