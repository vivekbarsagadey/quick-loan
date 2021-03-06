import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import {BsDatepickerConfig} from 'ngx-bootstrap';
import {Router} from '@angular/router';


@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {
  datePickerConfig: Partial<BsDatepickerConfig>;
  sendToServer: any;
  loanApplication: any;
  toggle: any;
  userDetails: boolean;
  addressDetails: boolean;
  bankDetails: boolean;
  contactDetails: boolean;
  employmentDetails: boolean;
  loanDetails: boolean;
  paymentDetails: boolean;
  user: any = {};

  constructor(private formBuilder: FormBuilder, private router: Router) {
    this.datePickerConfig = Object.assign({}, {
      minDate: new Date(2018, 0, 1),
      maxDate: new Date(2018, 11, 31),
      dateInputFormat: 'DD/MM/YYYY'
    });
    this.userDetails = true;
    this.addressDetails = false;
    this.bankDetails = false;
    this.contactDetails = false;
    this.employmentDetails = false;
    this.loanDetails = false;
    this.paymentDetails = false;
  }

  ngOnInit() {
  }
  applyForm(formValue) {
    switch (formValue) {
      case 'userDetails':
        this.userDetails = false;
        this.addressDetails = true;
        break;
      case 'addressDetails':
        this.addressDetails = false;
        this.bankDetails = true;
        break;
      case 'bankDetails':
        this.bankDetails = false;
        this.contactDetails = true;
        break;
      case 'contactDetails':
        this.contactDetails = false;
        this.employmentDetails = true;
        break;
      case 'employmentDetails':
        this.employmentDetails = false;
        this.loanDetails = true;
        break;
      case 'loanDetails':
        this.loanDetails = false;
        this.paymentDetails = true;
        break;
    }
  }
  applyFormPre(formValue) {
    switch (formValue) {
      case 'addressDetails':
        this.userDetails = true;
        this.addressDetails = false;
        break;
      case 'bankDetails':
        this.addressDetails = true;
        this.bankDetails = false;
        break;
      case 'contactDetails':
        this.bankDetails = true;
        this.contactDetails = false;
        break;
      case 'employmentDetails':
        this.contactDetails = true;
        this.employmentDetails = false;
        break;
      case 'loanDetails':
        this.employmentDetails = true;
        this.loanDetails = false;
        break;
      case 'paymentDetails':
        this.loanDetails = true;
        this.paymentDetails = false;
        break;
    }
  }
  openClickSubmit() {
    this.sendToServer = {
      'addressDetails': {
        'address': this.user.address,
        'state': this.user.state,
        'country': this.user.country,
        'stayType': this.user.stayType,
        'yrsInCurrentaddress': this.user.yrsInCurrentaddress,
        'city': this.user.city,
        'zipCode': this.user.zipCode,
        'monthsInCurrentaddress': this.user.monthsInCurrentaddress,
      },
      'bankDetails': {
        'abaOrRoutingNumber': this.user.abaOrRoutingNumber,
        'accountType': this.user.accountType,
        'accountNumber': this.user.accountNumber,
        'bankPhone': this.user.bankPhone,
        'bankName': this.user.bankName,
        'durationOfBankAccount': this.user.durationOfBankAccount,
        'monthlyIncome': this.user.monthlyIncome1
      },
      'contactDetails': {
        'emailId': this.user.emailId,
        'password': this.user.password,
        'cellPhone2': this.user.cellPhone2,
        'homePhone1': this.user.homePhone1,
        'homePhone3': this.user.homePhone3,
        'residentialStatus': this.user.residentialStatus,
        'confirmEmailId': this.user.confirmEmailId,
        'confirmPassword': this.user.confirmPassword,
        'cellPhone1': this.user.cellPhone1,
        'cellPhone3': this.user.cellPhone3,
        'homePhone2': this.user.homePhone2,
        'workPhone': this.user.workPhone,
        'dateOfMove': this.user.dateOfMove
      },
      'employmentDetails': {
        'companyName': this.user.companyName,
        'incomeType': this.user.incomeType,
        'employerName': this.user.employerName,
        'currentEmployedDuration': this.user.currentEmployedDuration,
        'companyAddress': this.user.companyAddress,
        'jobTitle': this.user.jobTitle,
        'employerPhone': this.user.employerPhone,
      },
      'userDetails': {
        'firstName': this.user.firstName,
        'middleName': this.user.middleName,
        'lastName': this.user.lastName,
        'maritalStatus': this.user.maritalStatus,
        'bestTimeToCall': this.user.bestTimeToCall,
        'doB': this.user.doB,
        'licenseNumber': this.user.licenseNumber,
        'licState': this.user.licState,
        'licIssueDate': this.user.licIssueDate,
        'licExpirationDate': this.user.licExpirationDate,
      },
      'loanDetails': {
        'loanAmount': this.user.loanAmount,
        'deadlineDate': this.user.deadlineDate,
        'loanPurpose': this.user.loanPurpose
      },
      'paymentDetails': {
        'paymentFrequency': this.user.paymentFrequency,
        'sortCode': this.user.sortCode,
        'bankAccount': this.user.bankAccount,
        'monthlyExpenses': this.user.monthlyExpenses,
        'secondPayDay': this.user.secondPayDay,
        'nexTPayDay': this.user.nexTPayDay,
        'monthlyIncome': this.user.monthlyIncome,
        'incomeSource': this.user.incomeSource,
        'paymentMethod': this.user.paymentMethod,
      }
    };

    fetch('http://192.168.100.12:8080/api/customer/',  {
      method: 'POST', // or 'PUT'
      body: JSON.stringify(this.sendToServer), // data can be `string` or {object}!
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res => this.applyForLoan(res))
      .catch(error => console.error('Error:', error));
  }
  applyForLoan(userData) {
    console.log('User data-----------:', userData);
    this.loanApplication = {
      'customerId': userData.id,
      'loanAmount': userData.loanDetails.loanAmount
    };
     fetch('http://192.168.100.12:8080/api/applications/',  {
      method: 'POST', // or 'PUT'
      body: JSON.stringify(this.loanApplication), // data can be `string` or {object}!
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(res => res.json())
      .then(res =>         this.router.navigate(['loan-status', {applicationId: res}]))
      .catch(error => console.error('Error:', error));
  }
}

