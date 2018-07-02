import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AboutComponent } from '../about/about.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';
import { HomeComponent } from '../home/home.component';
import {UserManagementModule} from '../user-management/user-management.module';
import {UserManagementComponent} from '../user-management/user-management.component';
import {UserListComponent} from '../user-management/user-list/user-list.component';
import {NewUserComponent} from '../user-management/new-user/new-user.component';
import {UserDetailComponent} from '../user-management/user-detail/user-detail.component';
import {ContactModule} from '../contact/contact.module';
import {ContactComponent} from '../contact/contact.component';
import { MenuComponent } from '../menu/menu.component';
import { ApplicationsComponent } from '../applications/applications.component';
import { LoginComponent } from '../login/login.component';
import { AppRouteComponent } from '../app-route/app-route.component';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'route', component: AppRouteComponent,
    children: [
      {path: 'home', component: HomeComponent},
      {path: 'contact' , component: ContactComponent},
      {path: 'about', component: AboutComponent},
      {path: 'user', component: UserManagementComponent,
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
        ]},
      {path: 'newuser' , component: UserManagementComponent,
        children: [
          {
            path: '',
            component: NewUserComponent,
          }
        ]},
      {path: 'applications', component: ApplicationsComponent},
      {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
      },
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
    ContactModule,
    RouterModule.forRoot(appRoutes),
    UserManagementModule,
  ],
  declarations: [  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
