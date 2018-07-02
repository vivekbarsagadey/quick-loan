'use strict';
var NS_assets = 'org.quickloan.assets';
var NS_participants = 'org.quickloan.participants';
var NS_transactions = 'org.quickloan.transactions';

/**
 * @param {org.quickloan.transactions.createApplication} createApplication - create application for customer
 * @transaction
 */

function createApplication(createApplication) {
  var applId = Math.random().toString(36).substring(3);
  var newApplication = getFactory().newResource(NS_assets, 'Applications', applId);
  newApplication.customer = createApplication.application.customer;
  newApplication.applicationDate = createApplication.application.applicationDate;
  newApplication.loanAmount = createApplication.application.loanAmount;
  newApplication.applicationStatus = createApplication.application.applicationStatus;
  newApplication.remarks = createApplication.application.remarks;
  newApplication.customer.allApplications.push(newApplication);

  return getAssetRegistry(NS_assets + '.Applications').then(function(ApplicationsRegistry) {
    return ApplicationsRegistry.add(newApplication);
  }).then(function() {
  return getParticipantRegistry(NS_participants + '.Customer')}).then(function(CustomerRegistry) {
    return CustomerRegistry.update(createApplication.application.customer);
  });
}

/**
 * @param {org.quickloan.transactions.requestInvestor} requestInvestor - send application to investor
 * @transaction
 */
function requestInvestor(requestInvestor) {
  requestInvestor.investor.applicationRequests.applicationId = requestInvestor.application.applicationId;
  requestInvestor.application.applicationStatus = "Application sent to Investor for approval";

  return getParticipantRegistry(NS_participants + '.Investor')
    .then(function(InvestorRegistry) {
    	return InvestorRegistry.update(requestInvestor.investor);
    })
  	.then(function() {
    	return getAssetRegistry(NS_assets + '.Applications');
    })
    .then(function(ApplicationsRegistry) {
    	return ApplicationsRegistry.update(requestInvestor.application);
  	})
    .then(function() {
    	return getParticipantRegistry(NS_participants + '.Customer')}).then(function(CustomerRegistry) {
        	return CustomerRegistry.update(requestInvestor.application.customer);
    });
}

/**
 * @param {org.quickloan.transactions.approveLoan} approveLoan - send application to investor
 * @transaction
 */
function approveLoan(approveLoan) {
  approveLoan.application.customer.lender.investorId = approveLoan.investor.investorId;
  //var temp = approveLoan.investor.applicationAssigned.applicationId;
  approveLoan.investor.applicationAssigned.applicationId = approveLoan.investor.applicationRequests.applicationId;
  //approveLoan.investor.applicationRequests.applicationId = temp;
  //approveLoan.investor.applicationRequests.applicationId = "NULL";
  approveLoan.application.applicationStatus = "Application approved by Investor";

  return getParticipantRegistry(NS_participants + '.Investor')
    .then(function(InvestorRegistry) {
    	return InvestorRegistry.update(approveLoan.investor);
    })
  	.then(function() {
    	return getAssetRegistry(NS_assets + '.Applications');
    })
    .then(function(ApplicationsRegistry) {
    	return ApplicationsRegistry.update(approveLoan.application);
  	})
    .then(function() {
    	return getParticipantRegistry(NS_participants + '.Customer')
    })
    .then(function(CustomerRegistry) {
        return CustomerRegistry.update(approveLoan.application.customer);
    });
}

/**
 * @param {org.quickloan.transactions.rejectLoan} rejectLoan - send application to investor
 * @transaction
 */
function rejectLoan(rejectLoan) {
  rejectLoan.application.applicationStatus = "Application rejected by Investor";
  rejectLoan.application.remarks = rejectLoan.remarks;

  return getAssetRegistry(NS_assets + '.Applications')
    .then(function(ApplicationsRegistry) {
    	return ApplicationsRegistry.update(rejectLoan.application);
    })
    .then(function() {
    	return getParticipantRegistry(NS_participants + '.Customer')
    })
    .then(function(CustomerRegistry) {
        return CustomerRegistry.update(rejectLoan.application.customer);
    });
}

/**
 * @param {org.quickloan.transactions.loanLent} loanLent - Change Loan Lent status
 * @transaction
 */

function loanLent(loanLent) {
  loanLent.application.applicationStatus = "Loan amount sent to customer";
  loanLent.application.customer.lender.totalLoanLent = loanLent.application.loanAmount;

  return getAssetRegistry(NS_assets + '.Applications')
    .then(function(ApplicationsRegistry) {
    	return ApplicationsRegistry.update(loanLent.application);
  }).then(function() {
  		return getParticipantRegistry(NS_participants + '.Customer')
  })
    .then(function(CustomerRegistry) {
    	return CustomerRegistry.update(loanLent.application.customer);
  })
  .then(function() {
  		return getParticipantRegistry(NS_participants + '.Investor')
  })
    .then(function(InvestorRegistry) {
    	return InvestorRegistry.update(loanLent.application.customer.lender);
  });
}

/**
 * @param {org.quickloan.transactions.loanRepaid} loanRepaid - Change Loan Repaid status
 * @transaction
 */

function loanRepaid(loanRepaid) {
  loanRepaid.application.applicationStatus = "Loan amount repaid by the customer";
  loanRepaid.application.customer.lender.totalLoanLent -= loanRepaid.application.loanAmount;

  return getAssetRegistry(NS_assets + '.Applications')
    .then(function(ApplicationsRegistry) {
    return ApplicationsRegistry.update(loanRepaid.application);
  })
    .then(function() {
  return getParticipantRegistry(NS_participants + '.Customer')})
    .then(function(CustomerRegistry) {
    return CustomerRegistry.update(loanRepaid.application.customer);
  })
  .then(function() {
  		return getParticipantRegistry(NS_participants + '.Investor')
  })
    .then(function(InvestorRegistry) {
    	return InvestorRegistry.update(loanRepaid.application.customer.lender);
  });
}
