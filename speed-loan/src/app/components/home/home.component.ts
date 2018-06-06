import { Component, OnInit, Input } from '@angular/core';
import {AppComponent} from '../../app.component';
import {ListElementService} from '../../services/list-element.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  @Input() appComponents: AppComponent;
  constructor(private elementService: ListElementService) {
    this.appComponents = new AppComponent();
  }

  ngOnInit() {
  }
  // isApplicationVisible() {
  //   this.elementService.isApplicationVisible();
  //   return false;
  // }
}
