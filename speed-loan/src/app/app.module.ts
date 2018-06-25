import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { WorkingComponent } from './components/working/working.component';
import { ApplyComponent } from './components/apply/apply.component';
import { FaqComponent } from './components/faq/faq.component';
import { ContactComponent } from './components/contact/contact.component';
import { ListElementComponent } from './list-element/list-element.component';
import { HomeComponent } from './components/home/home.component';
 // import {ListElementService} from './services/list-element.service';
// import { RformComponent } from './rform/rform.component';

const appRoutes: Routes = [
  { path: 'app', component: AppComponent},
  { path: 'list', component: ListElementComponent},
  { path: 'home', component: HomeComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'faq', component: FaqComponent},
  { path: 'working', component: WorkingComponent},
  { path: 'about', component: AboutComponent},
  { path: 'apply', component: ApplyComponent},
 // { path: 'form', component: RformComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    WorkingComponent,
    ApplyComponent,
    FaqComponent,
    ContactComponent,
    ListElementComponent,
    HomeComponent,
   // RformComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule
  ],
  // providers: [ListElementService],
  bootstrap: [AppComponent]
})
export class AppModule { }
