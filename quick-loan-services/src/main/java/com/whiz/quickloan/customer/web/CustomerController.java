package com.whiz.quickloan.customer.web;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whiz.quickloan.QuickloanApplication;
import com.whiz.quickloan.applications.domain.Application;
import com.whiz.quickloan.customer.domain.Customer;
import com.whiz.quickloan.customer.domain.CustomerStatus;
import com.whiz.quickloan.customer.services.CustomerRepository;
import com.whiz.quickloan.ledger.mapper.CustomerMapper;
import com.whiz.quickloan.ledger.services.LedgerCustomerServices;
import com.whiz.quickloan.user.domain.QuickLoanUserDetails;
import com.whiz.quickloan.user.domain.User;
import com.whiz.quickloan.user.domain.UserRole;
import com.whiz.quickloan.user.repository.UserRepository;
import com.whiz.quickloan.user.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private LedgerCustomerServices ledgerCustomerServices;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	

	@ApiOperation(value = "View a list of available Customers", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Customer> list(Model model) {
		Iterable<Customer> CustomerList = customerRepository.findAll();
		return CustomerList;
	}

	@ApiOperation(value = "Add a Customer")
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity saveCustomer(@RequestBody Customer customer) {
		
		String emailId = customer.getContactDetails().getEmailId();
		String password = customer.getContactDetails().getPassword();
		if (null == emailId || null == password	|| "" == emailId || "" == customer.getContactDetails().getPassword()) 
			return new ResponseEntity("Please enter email and password", HttpStatus.BAD_REQUEST);
		if(null != userRepository.findByEmailId(emailId)) 
			return new ResponseEntity("This email id is already registered...please use another email id..!!!", HttpStatus.BAD_REQUEST);
		
		customer.setScore(5);
		customer.setStatus(CustomerStatus.ACTIVE);
		
		// save customer in DB
		customer.getUserDetails().setCustomer(customer);
		customer.getAddressDetails().setCustomer(customer);
		customer.getContactDetails().setCustomer(customer);
		customer.getEmploymentDetails().setCustomer(customer);
		customer.getPaymentDetails().setCustomer(customer);
		customer.getBankDetails().setCustomer(customer);
		customer.getLoanDetails().setCustomer(customer);
		
		customer = customerRepository.save(customer);

		// save customer in ledger
		if(QuickloanApplication.blockChainENabled)
			ledgerCustomerServices.saveCustomer(CustomerMapper.map(customer));

		// save user in DB
		User user = new User();
		user.setId(0);
		user.setEmailId(customer.getContactDetails().getEmailId());
		user.setPassword(customer.getContactDetails().getPassword());
		user.setRoles(Arrays.asList(new UserRole("CUSTOMER")));
		
		QuickLoanUserDetails quickLoanUserDetails = new QuickLoanUserDetails(user);
		userRepository.save(user);
		

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a Customer")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {

		Customer storedCustomer = customerRepository.findById(id).orElse(null);

		
		if (storedCustomer != null) {

			// Update user
			User user = userRepository.findByEmailId(storedCustomer.getContactDetails().getEmailId());
			if (null != user && null != storedCustomer.getContactDetails().getEmailId() && null != storedCustomer.getContactDetails().getPassword()) {
				user.setEmailId(customer.getContactDetails().getEmailId());
				user.setPassword(customer.getContactDetails().getPassword());
				userRepository.save(user);
			}
			
			// Update customer
			storedCustomer.updateCustomer(customer);
			customerRepository.save(storedCustomer);

			// update ledger
			//ledgerCustomerServices.updateCustomer(CustomerMapper.map(storedCustomer));
			
			return new ResponseEntity("Customer updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity("Customer update fail", HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Delete a Customer")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@Transactional
	public ResponseEntity delete(@PathVariable Integer id) {

		// delete user
		Customer storedCustomer = customerRepository.findById(id).orElse(null);
		if (storedCustomer != null) {
			User user = userRepository.findByEmailId(storedCustomer.getContactDetails().getEmailId());
			if(null != user)
				userService.deleteUserById(user.getId());
		}

		// delete customer
		customerRepository.deleteById(id);
		
		
		// delete customer from ledger
		if(QuickloanApplication.blockChainENabled)
			ledgerCustomerServices.deleteCustomer(id);
		
		return new ResponseEntity("Customer deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Search a Customer with an ID", response = Customer.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public Customer showCustomer(@PathVariable Integer id, Model model) {
		return customerRepository.findById(id).orElse(new Customer());
	}

	@ApiOperation(value = "LedgerCustomerServices test", response = Application.class)
	@RequestMapping(value = "/LedgerCustomerServices/", method = RequestMethod.GET, produces = "application/json")
	public String testLedgerCustomerServices(Model model) {
		return ledgerCustomerServices.getCustomer();
	}
}