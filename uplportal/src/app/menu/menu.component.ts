import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  userName: string;
  userId: number;
  userRole: string;
  constructor(private router: Router) {
   const userData = JSON.parse(localStorage.getItem('userData'));
   this.userName = userData.user.userName;
   this.userId = userData.user.id;
   this.userRole = userData.user.role;
  }

  ngOnInit() {
  }
  signOut() {
    localStorage.removeItem('userData');
    this.router.navigateByUrl('login');
  }
}
