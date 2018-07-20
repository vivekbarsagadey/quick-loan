import { BrowserModule } from '@angular/platform-browser';
import { NgModule , LOCALE_ID } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import {UserManagementModule} from './user-management/user-management.module';
import {ContactModule} from './contact/contact.module';
import { FormComponent } from './form/form.component';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { ApplicationComponent } from './application/application.component';
import { ProfileComponent } from './profile/profile.component';
import {UserManagementComponent} from "./user-management/user-management.component";
import { CustomerManagementComponent } from './customer-management/customer-management.component';
import { InvestorManagementComponent } from './investor-management/investor-management.component';
// import { SidebarComponent } from './sidebar/sidebar.component';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'home', component: FormComponent},
  {path: 'applications', component: ApplicationComponent},
  {path: 'about', component: AboutComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'user-management', component: UserManagementComponent},
  {path: 'customers', component: CustomerManagementComponent},
  {path: 'investors', component: InvestorManagementComponent},
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    AboutComponent,
    PageNotFoundComponent,
    HomeComponent,
 //   SidebarComponent,
    FormComponent,
    LoginComponent,
    ApplicationComponent,
    ProfileComponent,
    CustomerManagementComponent,
    InvestorManagementComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    ContactModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    UserManagementModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],

  exports: [
 //   SidebarComponent
  ],

  providers: [{ provide: LOCALE_ID, useValue: 'fr' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
