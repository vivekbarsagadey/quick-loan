import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { ApplicationComponent } from './application/application.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomePageComponent } from './home-page/home-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AboutUsComponent } from './about-us/about-us.component';
import { HowItWorksComponent } from './how-it-works/how-it-works.component';
import { FaqComponent } from './faq/faq.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {BsDatepickerModule} from 'ngx-bootstrap';
import { LoanApplicationComponent } from './loan-application/loan-application.component';


const appRoutes: Routes = [
  {path: 'home', component: HomePageComponent},
  {path: 'apply', component: ApplicationComponent},
  {path: 'about-us', component: AboutUsComponent},
  {path: 'how-it-works', component: HowItWorksComponent},
  {path: 'faq', component: FaqComponent},
  {path: 'contact-us', component: ContactUsComponent},
  {path: 'loan-status', component: LoanApplicationComponent},
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {path: '**', component: ApplicationComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ApplicationComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    AboutUsComponent,
    HowItWorksComponent,
    FaqComponent,
    ContactUsComponent,
    LoanApplicationComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BsDatepickerModule.forRoot(),
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
