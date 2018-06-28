import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  adminObject: any;

  constructor() {
    this.adminObject = JSON.parse(localStorage.getItem('admin'));
  }
  ngOnInit() {
  }

}
