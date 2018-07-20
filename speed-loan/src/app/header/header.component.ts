import { Component, OnInit } from '@angular/core';
import $ from 'src/lib/jquery/jquery.min.js';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  target: any;
  constructor() { }

  ngOnInit() {}

}
