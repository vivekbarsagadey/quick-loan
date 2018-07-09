package com.whiz.quickloan.ledger.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.customer.services.CustomerRepository;
import com.whiz.quickloan.ledger.mapper.TxBlockCustomerMapper;
import com.whiz.quickloan.ledger.transactions.services.LedgerTxBlockCustomerServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ledger")
public class TxBlockCustomerController {
	
	@Autowired
	private LedgerTxBlockCustomerServices ledgerTxBlockCustomerServices;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@ApiOperation(value = "block test")
	@RequestMapping(value = "/customer/block/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity block(@PathVariable Integer id) {
		customerRepository.findById(id).ifPresent(consumer -> {
			ledgerTxBlockCustomerServices.blockCustomer(TxBlockCustomerMapper.map(consumer));
			
		});
		
		/*Customer c = new Customer();
		c.setId(1);
		
		ledgerTxBlockCustomerServices.blockCustomer(TxBlockCustomerMapper.map(c));*/
		
		return new ResponseEntity("Customer blocked successfully", HttpStatus.OK);
	}
	
}