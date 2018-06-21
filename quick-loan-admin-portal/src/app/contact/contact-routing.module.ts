import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ContactComponent} from './contact.component';

const appContactRoutes: Routes = [
  {path: 'contact' , component: ContactComponent}
];


@NgModule({
  imports:      [ RouterModule.forChild(appContactRoutes) ],
  exports:      [ RouterModule ],
})
export class ContactRouterModule { }
