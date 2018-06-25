import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AwesomePipe } from './awesome.pipe';
import {RouterModule, Routes} from '@angular/router';
import { ContactComponent } from './contact.component';
import { ContactService } from './contact.service';
import { HighlightDirective } from './highlight.directive';
import {ContactRouterModule} from './contact-routing.module';

@NgModule({
  imports:      [ CommonModule, FormsModule , ContactRouterModule ],
  declarations: [ ContactComponent, HighlightDirective, AwesomePipe ],
  providers:    [ ContactService ]
})
export class ContactModule { }
