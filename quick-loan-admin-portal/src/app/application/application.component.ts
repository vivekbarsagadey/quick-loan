import { Component, OnInit } from '@angular/core';
import {UrlConstant} from '../util/url-constant';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss']
})
export class ApplicationComponent implements OnInit {
  investorList: any;
  mySelectedInvestor: any
  applicationList: any;

  constructor() {  }

  ngOnInit() {
    this.getApplications();
    this.getInvestors();
  }

  getApplications() {
    fetch(UrlConstant.JAVA_API + 'applications/', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);

        this.applicationList = res;
      });
  }

  getInvestors() {
    fetch(UrlConstant.JAVA_API + 'investor/', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);

        this.investorList = res;
      });
  }

  getRequestInvestor(applicationId) {
    console.log('Investor selected for mySelect------->>>>', this.mySelectedInvestor);
    const investorId = this.mySelectedInvestor;
    fetch(UrlConstant.JAVA_API + 'ledger/application/request/' + applicationId + '?investorId=' + investorId, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },

    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.applicationList = res;
      });
  }


  /*changeStatus(application){
    fetch(UrlConstant.JAVA_API + "ledger/investor/block/" + application.id, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },

    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.applicationList = res;
      });
  }*/

  deleteApplication(applicationId) {
    fetch(UrlConstant.JAVA_API + 'applications/' + applicationId, {
      method: 'delete',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);

        this.applicationList = res;
      });
  }
}
