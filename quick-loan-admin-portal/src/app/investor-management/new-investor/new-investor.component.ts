import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-investor',
  templateUrl: './new-investor.component.html',
  styleUrls: ['./new-investor.component.scss']
})
export class NewInvestorComponent implements OnInit {
  sendToServer: any;
  investor: any = {};


  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
     console.log(this.investor);

    this.sendToServer = {
      'addressDetails': {
        'companyAddress': this.investor.companyAddress,
        'companyCity': this.investor.companyCity,
        'companyCountry': this.investor.companyCountry,
        'companyState': this.investor.companyState,
        'companyZipCode': this.investor.companyZipCode
      },
      'bankDetails': {
        'abaOrRoutingNumber': this.investor.abaOrRoutingNumber,
        'accountNumber': this.investor.accountNumber,
        'accountType': this.investor.accountType,
        'bankName': this.investor.bankName,
        'bankPhone': this.investor.bankPhone,
        'durationOfBankAccount': this.investor.durationOfBankAccount
      },
      'companyName': this.investor.companyName,
      'contactDetails': {
        'cellPhone1': this.investor.cellPhone1,
        'cellPhone2': this.investor.cellPhone2,
        'companyEmailId': this.investor.companyEmailId,
        'companyWebsite': this.investor.companyWebsite,
        'workPhone1': this.investor.workPhone1,
        'workPhone2': this.investor.workPhone2
      },
      'loanRange': this.investor.loanRange,
      'paymentDetails': {
        'rateOfInterest': this.investor.rateOfInterest
      },
      'totalLoanLent': this.investor.totalLoanLent
    };

    fetch('http://192.168.100.12:8080/api/investor/',  {
      method: 'POST', // or 'PUT'
      body: JSON.stringify(this.sendToServer), // data can be `string` or {object}!
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .catch(error => console.error('Error:', error))
      .then(response => this.router.navigateByUrl('qlap/investors'));
  }
}
