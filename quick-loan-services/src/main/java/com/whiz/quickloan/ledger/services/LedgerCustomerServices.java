package com.whiz.quickloan.ledger.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.domain.Customer;

@Service
public class LedgerCustomerServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerCustomerServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getCustomer() {
		String customer = "";
		try {
			//RestTemplate restTemplate = new RestTemplate();
			customer = restTemplate.getForObject(LedgerConstant.API_URL + "Customer", String.class);
			log.info(customer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return customer;
	}
	
	public String saveCustomer(Customer customer) {
		ResponseEntity<Customer> responseCustomer  = null;
		
		try {
			log.info(customer.toString());
			
			
			/*List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
			interceptors.add(new LoggingRequestInterceptor());
			restTemplate.setInterceptors(interceptors);
*/
			//RestTemplate restTemplate = new RestTemplate();
			responseCustomer  =  restTemplate.postForEntity(LedgerConstant.API_URL + "Customer", customer, Customer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return responseCustomer.getBody().toString();
	}


/*	public String saveCustomerOld(Customer customer) {
		ResponseEntity<String> response  = null;
		try {
			log.info(customer.toString());
			RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
			List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
			interceptors.add(new LoggingRequestInterceptor());
			restTemplate.setInterceptors(interceptors);

			//RestTemplate restTemplate = new RestTemplate();
			response  = restTemplate.postForEntity(LedgerConstant.API_URL + "Customer",customer.toString(),String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getBody();
	}*/
}