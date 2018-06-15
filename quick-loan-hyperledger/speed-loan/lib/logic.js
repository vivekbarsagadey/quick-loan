'use strict';
var NS = 'org.speedloan.core';

/**
 * @param {org.speedloan.core.createApplication} createApplication - create customer with application
 * @transaction
 */

function createApplication(createApplication) {
  var applId = Math.random().toString(36).substring(3);
  var newApplication = getFactory().newResource(NS, 'Applications', applId);
  newApplication.customer = createApplication.application.customer;
  newApplication.applicationDate = createApplication.application.applicationDate;
  newApplication.loanAmount = createApplication.application.loanAmount;
  newApplication.applicationStatus = createApplication.application.applicationStatus;
  newApplication.remarks = createApplication.application.remarks;
  newApplication.customer.allApplications.push(newApplication);

  return getAssetRegistry(NS + '.Applications').then(function(ApplicationsRegistry) {
    return ApplicationsRegistry.add(newApplication);
  }).then(function() {
  return getParticipantRegistry(NS + '.Customer')}).then(function(CustomerRegistry) {
    return CustomerRegistry.update(createApplication.application.customer);
  });

}

/**
 * @param {org.speedloan.core.requestInvestor} requestInvestor - send application to investor
 * @transaction
 */
function requestInvestor(requestInvestor) {
  requestInvestor.investor.applicationRequests.applicationId = requestInvestor.application.applicationId;
  requestInvestor.application.applicationStatus = "Application sent to Investor for approval";

  return getParticipantRegistry(NS + '.Investor')
    .then(function(InvestorRegistry) {
    	return InvestorRegistry.update(requestInvestor.investor);
    })
  	.then(function() {
    	return getAssetRegistry(NS + '.Applications');
    })
    .then(function(ApplicationsRegistry) {
    	return ApplicationsRegistry.update(requestInvestor.application);
  	})
    .then(function() {
    	return getParticipantRegistry(NS + '.Customer')}).then(function(CustomerRegistry) {
        	return CustomerRegistry.update(requestInvestor.application.customer);
    });
}

/**
 * @param {org.speedloan.core.approveLoan} approveLoan - send application to investor
 * @transaction
 */
function approveLoan(approveLoan) {
  //approveLoan.investor.applicationRequests.applicationId = 0;//approveLoan.application."NoAppl";
  approveLoan.application.customer.lender.investorId = approveLoan.investor.investorId;
  approveLoan.investor.applicationAssigned.applicationId = approveLoan.application.customer.allApplications.applicationId;
  approveLoan.application.applicationStatus = "Loan Approved";

  return getParticipantRegistry(NS + '.Investor')
    .then(function(InvestorRegistry) {
    	return InvestorRegistry.update(approveLoan.investor);
    })
  	.then(function() {
    	return getAssetRegistry(NS + '.Applications');
    })
    .then(function(ApplicationsRegistry) {
    	return ApplicationsRegistry.update(approveLoan.application);
    })
    .then(function() {
    	return getParticipantRegistry(NS + '.Customer');
    })
    .then(function(CustomerRegistry) {
    	return CustomerRegistry.update(approveLoan.customer);
  	});
}
