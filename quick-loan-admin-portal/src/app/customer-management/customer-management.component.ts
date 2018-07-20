import { Component, OnInit } from '@angular/core';
import {UrlConstant} from "../util/url-constant";

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html',
  styleUrls: ['./customer-management.component.scss']
})
export class CustomerManagementComponent implements OnInit {
  customers: any;

  constructor() { }

  ngOnInit() {
    this.getCustomers();
  }

  getCustomers(){
    fetch(UrlConstant.JAVA_API + "customer/", {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.customers = res;
      });
  }

  changeStatus(customer){
    fetch(UrlConstant.JAVA_API + "customer/", {
      method: 'POST',
      body: customer.id,
      headers: {
        'Content-Type': 'application/json'
      },

    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.customers = res;
      });
  }

  deleteCustomer(customerId){
    fetch(UrlConstant.JAVA_API + "customer/" + customerId, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => {
        console.log('response from server.........', res);
        this.customers = res;
      });
  }
}
