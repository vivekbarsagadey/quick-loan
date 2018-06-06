import { Component, OnInit, Input } from '@angular/core';
import {ListElement} from './list-element.model';
import {AppComponent} from '../app.component';
@Component({
  selector: 'app-list-element',
  templateUrl: './list-element.component.html',
  styleUrls: ['./list-element.component.css']
})
export class ListElementComponent implements OnInit {
  @Input() elements: ListElement;
  @Input() appComponents: AppComponent;
  constructor() {
    this.elements = new ListElement();
    this.appComponents = new AppComponent();
  }


  isHomeVisible() {
    this.elements.displayHome();
    return false;
  }
  isAboutVisible() {
    this.elements.displayAbout();
    return false;
  }
  isWorkingVisible() {
    this.elements.displayWorking();
    return false;
  }
  isApplicationVisible() {
    this.elements.displayApplication();
    return false;
  }
  isFaqVisible() {
    this.elements.displayFaq();
    return false;
  }
  isContactVisible() {
    this.elements.displayContact();
    return false;
  }

  ngOnInit() {
  }

}
