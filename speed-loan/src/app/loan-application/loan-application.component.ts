import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {ActivatedRoute, Router, Params} from '@angular/router';
import { UrlConstants } from '../common/url-constants';

@Component({
  selector: 'app-loan-application',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.scss']
})

export class LoanApplicationComponent implements OnInit {
  user: any;
  dispalyMessage: String;
  display: any;
  applicationId: any;
  constructor(private route: ActivatedRoute,
              private router: Router) {    this.route.params.subscribe(params => {
      this.applicationId = JSON.parse(params['applicationId']);
    });
  }

  ngOnInit() {
    this.display = 'none';
    fetch( UrlConstants.APPLICATION_URL + this.applicationId, {
      method: 'get',
      mode: 'cors'
    }).then(response => {
      console.log(response);
      return response.json();
    }).then(res => {
      console.log(res);
      this.user = res;
      this.displayScreenMessage();
      // this.users = res.filter((user) => user['investorId'] === this.userId );
    }).catch(err => {}
    );
  }

  displayScreenMessage() {
    this.dispalyMessage = '';
    if (!(this.user.id)) {
      this.dispalyMessage = 'No Pending Application Requests';
    }
  }

  onCloseHandled() {
    this.display = 'none';
  }
  onClickLoanRepaid(applicationId) {
    fetch(UrlConstants.APPLICATION_LEDGER_URL + 'updateStatus/' + applicationId + '/LOAN_REPAID',  {
      method: 'GET',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then((res) => console.log(res)
    );
  }
  onClickReceivedBtn(applicationId) {
    fetch(UrlConstants.APPLICATION_LEDGER_URL + 'updateStatus/' + applicationId + '/LOAN_RECEIVED',  {
      method: 'GET',
      headers: new Headers({
        'Content-Type': 'text/plain'
      })
    }).then((res) => console.log(res)
    );
  }
  /* getFullName(user: User) {
       return [user.lastName, user.firstName].join(',');
     }*/

}
