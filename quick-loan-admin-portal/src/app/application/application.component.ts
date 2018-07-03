import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss']
})
export class ApplicationComponent implements OnInit {
  applicationList: any;
  renderedList: any;
  constructor() {
    this.applicationList = [
      { status : 'approved', name: 'List 1'},
      { status : 'rejected', name: 'List 2'},
      { status : 'pending', name: 'List 3'},
      { status : 'pending', name: 'List 4'},
      { status : 'approved', name: 'List 5'},
      { status : 'rejected', name: 'List 6'},
      { status : 'rejected', name: 'List 7'},
      { status : 'rejected', name: 'List 8'},
      { status : 'approved', name: 'List 9'}
    ];
  }

  ngOnInit() {
    this.renderedList = this.applicationList;
  }
  renderApplicationList(event?: any) {
    if (event.target.value !== 'all') {
      this.renderedList = this.applicationList.filter(elem => {
        return elem.status === event.target.value;
      });
    } else {
      this.renderedList = this.applicationList;
    }

  }
}
