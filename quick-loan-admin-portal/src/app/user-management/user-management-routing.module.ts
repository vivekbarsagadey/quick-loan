import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UserManagementComponent} from './user-management.component';
import {UserListComponent} from './user-list/user-list.component';
import {UserDetailComponent} from './user-detail/user-detail.component';
import {NewUserComponent} from './new-user/new-user.component';



const appUserRoutes: Routes = [
  {path: 'user' , component: UserManagementComponent,
    children: [
      {
        path: '',
        component: UserListComponent
      },
      {
        path: ':id',
        component: UserDetailComponent
      },
      {
        path: 'newuser',
        component: NewUserComponent
      }
    ]

  },
  {path: 'newuser' , component: UserManagementComponent,
    children: [
      {
        path: '',
        component: NewUserComponent,
      }
    ]

  }
  /*,
  {path:'users' , component:UserListComponent},
  {path : 'userdetail/:id',component : UserDetailComponent}*/
];


@NgModule({
  imports: [
    CommonModule, RouterModule.forChild(appUserRoutes)
  ],
  declarations: [],
  exports: [
    RouterModule
  ]
})
export class UserManagementRoutingModule { }
