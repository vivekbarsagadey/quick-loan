import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgModule} from '@angular/compiler/src/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})

/*@NgModule({
  exports: [
    SidebarComponent
  ]
})*/

export class SidebarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

}
