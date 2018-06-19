import { Component, OnInit, Input, OnChanges } from '@angular/core';
import $ from 'node_modules/jquery/dist/jquery.js';

@Component({
  selector: 'app-application-details',
  templateUrl: './application-details.component.html',
  styleUrls: ['./application-details.component.scss']
})
export class ApplicationDetailsComponent implements OnInit {
  @Input() userInfo;
  @Input() display;
  constructor() {
  }
  ngOnInit() {
    fetch('http://localhost:8080/api/customer/' + this.userInfo.id, {
      method: 'get',
      mode: 'cors'
    }).then(response => {
      console.log(response);
      return response.json();
    }).then(res => {
      console.log('res>>>>>>>>>>>>>>', res);
      this.userInfo = res;
    }).catch(err => {
      }
      // Error :(
    );
  }
  onCloseHandled() {
    this.display = 'none';
    $('.backdrop').css('display', 'none');
    $('.modal').css('display', 'none');
  }
}
