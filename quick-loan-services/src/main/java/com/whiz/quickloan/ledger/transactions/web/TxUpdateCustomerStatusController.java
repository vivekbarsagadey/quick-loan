package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.customer.domain.CustomerStatus;
import com.whiz.quickloan.customer.services.CustomerRepository;
import com.whiz.quickloan.ledger.mapper.TxUpdateCustomerStatusMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxUpdateCustomerStatusServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
@CrossOrigin
public class TxUpdateCustomerStatusController {

	@Autowired
	private LedgerTxUpdateCustomerStatusServices ledgerTxUpdateCustomerStatusServices;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@ApiOperation(value = "update customer")
	@RequestMapping(value = "/customer/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity block(@PathVariable Integer id, @PathVariable CustomerStatus status) {
		customerRepository.findById(id).ifPresent(customer -> {
			customer.setStatus(status);
			customer = customerRepository.save(customer);
			ledgerTxUpdateCustomerStatusServices.updateCustomerStatus(TxUpdateCustomerStatusMapper.map(customer));
			
		});
		return new ResponseEntity("Customer status changed successfully", HttpStatus.OK);
	}
	
	/*@ApiOperation(value = "unblock customer")
	@RequestMapping(value = "/customer/unblock/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity unblock(@PathVariable Integer id) {
		customerRepository.findById(id).ifPresent(customer -> {
			customer.setStatus(Status.UNBLOKED);
			customer = customerRepository.save(customer);
			ledgerTxUpdateCustomerStatusServices.updateCustomerStatus(TxUpdateCustomerStatusMapper.map(customer));
			
		});
		return new ResponseEntity("Customer blocked successfully", HttpStatus.OK);
	}*/
}
