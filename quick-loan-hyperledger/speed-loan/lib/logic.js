'use strict';
var NS_assets = 'org.whizit.pronto.assets';
var NS_participants = 'org.whizit.pronto.participants';
var NS_transactions = 'org.whizit.pronto.transactions';

/**
 * @param {org.whizit.pronto.transactions.requestInvestor} requestInvestor - send application to Investor
 * @transaction
 */

function requestInvestor(requestInvestor) {
  requestInvestor.application.status = "INVESTOR_REQUESTED";
  requestInvestor.application.state = "IN_PROCESS";
  requestInvestor.application.investor.id = requestInvestor.investor.id;
  
  return getAssetRegistry(NS_assets + '.Applications').then(function(ApplicationsRegistry) {
    return ApplicationsRegistry.update(requestInvestor.application);
  });
}

/**
 * @param {org.whizit.pronto.transactions.updateScore} updateScore - Update credit score of Customer
 * @transaction
 */

function updateScore(updateScore) {
  updateScore.customer.score += 2;

  return getParticipantRegistry(NS_participants + '.Customer').then(function(CustomerRegistry) {
    return CustomerRegistry.update(updateScore.customer);
  });
}

/**
 * @param {org.whizit.pronto.transactions.updateCustomerStatus} updateCustomerStatus - Update Customer Status
 * @transaction
 */

function updateCustomerStatus(updateCustomerStatus) {
  updateCustomerStatus.customer.status = updateCustomerStatus.status;
  
  return getParticipantRegistry(NS_participants + '.Customer').then(function(CustomerRegistry) {
    return CustomerRegistry.update(updateCustomerStatus.customer);
  });
}

/**
 * @param {org.whizit.pronto.transactions.updateInvestorStatus} updateInvestorStatus - Update Investor Status
 * @transaction
 */

function updateInvestorStatus(updateInvestorStatus) {
  updateInvestorStatus.investor.status = updateInvestorStatus.status;
  
  return getParticipantRegistry(NS_participants + '.Investor').then(function(InvestorRegistry) {
    return InvestorRegistry.update(updateInvestorStatus.investor);
  });
}

/**
 * @param {org.whizit.pronto.transactions.updateApplicationStatus} updateApplicationStatus - Update Application Status
 * @transaction
 */

function updateApplicationStatus(updateApplicationStatus) {
  updateApplicationStatus.application.status = updateApplicationStatus.status;
  updateApplicationStatus.application.remarks = updateApplicationStatus.remarks;
  
  return getAssetRegistry(NS_assets + '.Applications').then(function(ApplicationsRegistry) {
    return ApplicationsRegistry.update(updateApplicationStatus.application);
  });
}
