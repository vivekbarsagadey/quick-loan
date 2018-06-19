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
import { ApplicationComponent } from './application/application.component';
import { ApplicationDetailsComponent } from './application-details/application-details.component';

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'application', component: ApplicationComponent},
  {
    path: '',
    redirectTo: '/home',
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
    ApplicationComponent,
    ApplicationDetailsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    ContactModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    UserManagementModule,
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
