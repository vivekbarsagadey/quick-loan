'use strict';
var NS = 'org.speedloan.core';

/**
 * @param {org.speedloan.core.requestInvestor} requestInvestor - send application to investor
 * @transaction
 */
function requestInvestor(requestInvestor) {
  requestInvestor.investor.applicationRequests = requestInvestor.application.applicationId;
  requestInvestor.application.applicationStatus = "Investor Requested";

  return getParticipantRegistry('org.speedloan.core.Investor')
    .then(function (ParticipantRegistry) {
    	return ParticipantRegistry.update(requestInvestor.investor);
    })
  	.then(function() {
    	return getAssetRegistry('org.speedloan.core.Applications');
    })
    .then(function (AssetRegistry) {
    	return AssetRegistry.update(requestInvestor.application);
  	})
}
