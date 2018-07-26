import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { CommonModule } from '@angular/common';
import {InvestorManagementComponent} from "../investor-management/investor-management.component";
import {CustomerManagementComponent} from "../customer-management/customer-management.component";
import {UserManagementComponent} from "../user-management/user-management.component";
import {ProfileComponent} from "../profile/profile.component";
import {AboutComponent} from "../about/about.component";
import {ApplicationComponent} from "../application/application.component";
import {FormComponent} from "../form/form.component";
import {AppRouteComponent} from "../app-route/app-route.component";
import {LoginComponent} from "../login/login.component";
import {PageNotFoundComponent} from "../page-not-found/page-not-found.component";
// import {Routes} from "@angular/router";
import {NewInvestorComponent} from "../investor-management/new-investor/new-investor.component";
import {UserListComponent} from "../user-management/user-list/user-list.component";
import {UserDetailComponent} from "../user-management/user-detail/user-detail.component";
import {NewUserComponent} from "../user-management/new-user/new-user.component";
import {UserManagementModule} from "../user-management/user-management.module";

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'qlap', component: AppRouteComponent,
    children: [
      {path: 'home', component: FormComponent},
      {path: 'applications', component: ApplicationComponent},
      {path: 'about', component: AboutComponent},
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

      },
      {path: 'profile', component: ProfileComponent},
      {path: 'customers', component: CustomerManagementComponent},
      {path: 'investors', component: InvestorManagementComponent},
      {
        path: 'new',
        component: NewInvestorComponent,
      },
      {path: '', redirectTo: 'home', pathMatch: 'full'},
    ]},
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes),
    UserManagementModule
  ],
  declarations: [],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
