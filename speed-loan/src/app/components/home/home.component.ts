import { Component, OnInit, Input } from '@angular/core';
import {AppComponent} from '../../app.component';
import {ListElementComponent} from '../../list-element/list-element.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  @Input() appComponents: AppComponent;
  @Input() ListElementComponents: ListElementComponent;
  constructor() {
    this.appComponents = new AppComponent();
    this.ListElementComponents = new ListElementComponent();
  }

  ngOnInit() {
  }

}
