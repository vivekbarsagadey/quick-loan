import { Component, OnInit } from '@angular/core';
import { UrlConstant } from '../util/url-constant';

@Component({
  selector: 'app-investor-management',
  templateUrl: './investor-management.component.html',
  styleUrls: ['./investor-management.component.scss']
})
export class InvestorManagementComponent implements OnInit {
  investors: any;
  constructor() { }

  ngOnInit() {
    this.getInvestors();
  }

  getInvestors(){
    fetch(UrlConstant.JAVA_API + "investor/", {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.investors = res;
      });
  }

  changeStatus(investor){
    fetch(UrlConstant.JAVA_API + "ledger/investor/block/" + investor.id, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },

    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.investors = res;
      });
  }

  deleteInvestor(investorId){
    fetch(UrlConstant.JAVA_API + "investor/" + investorId, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.investors = res;
      });
  }
}
