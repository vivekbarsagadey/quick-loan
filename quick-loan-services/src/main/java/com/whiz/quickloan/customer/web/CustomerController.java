package com.whiz.quickloan.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.whiz.quickloan.applications.domain.Applications;
import com.whiz.quickloan.customer.domain.BestTimeToCall;
import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.customer.services.CustomerRepository;
import com.whiz.quickloan.ledger.mapper.CustomerMapper;
import com.whiz.quickloan.ledger.services.LedgerCustomerServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LedgerCustomerServices ledgerCustomerServices;
	
	@ApiOperation(value = "View a list of available Customers", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Customer> list(Model model) {
		Iterable<Customer> CustomerList = customerRepository.findAll();
		return CustomerList;
	}

	@ApiOperation(value = "Add a Customer")
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveCustomer(@RequestBody Customer customer) {
		customer.setBestTimeToCall(BestTimeToCall.MORNING);
		customer.getAddressDetails().setCustomer(customer);
		customer.getContactDetails().setCustomer(customer);
		customer.getEmploymentDetails().setCustomer(customer);
		customer.getPaymentDetails().setCustomer(customer);
		customer.getBankDetails().setCustomer(customer);
		customer.getLoanDetails().setCustomer(customer);
		customerRepository.save(customer);
		
		// update ledger data
		System.out.println(ledgerCustomerServices.saveCustomer(CustomerMapper.map(customer)));
		
		return new ResponseEntity("Customer saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update a Customer")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {

		Customer storedCustomer = customerRepository.findById(id).orElse(null);
		if(storedCustomer !=null) {
			/*storedCustomer.setDescription(customer.get);
			storedCustomer.setImageUrl(customer.getImageUrl());
			storedCustomer.setPrice(customer.getPrice());*/
			customerRepository.save(storedCustomer);
			return new ResponseEntity("Customer updated successfully", HttpStatus.OK);
		}else {
			return new ResponseEntity("Customer update fail", HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Delete a Customer")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
		customerRepository.deleteById(id);
		return new ResponseEntity("Customer deleted successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Search a Customer with an ID", response = Customer.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public Customer showCustomer(@PathVariable Integer id, Model model) {
		return customerRepository.findById(id).orElse(new Customer());
	}
	
	
	@ApiOperation(value = "LedgerCustomerServices test", response = Applications.class)
	@RequestMapping(value = "/LedgerCustomerServices/", method = RequestMethod.GET, produces = "application/json")
	public String testLedgerCustomerServices(Model model) {
		return ledgerCustomerServices.getCustomer();
	}
}