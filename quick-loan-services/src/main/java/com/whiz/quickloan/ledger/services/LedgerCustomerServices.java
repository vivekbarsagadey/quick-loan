package com.whiz.quickloan.ledger.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.domain.Customer;
import com.whiz.quickloan.ledger.interceptor.LoggingRequestInterceptor;

@Service
public class LedgerCustomerServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerCustomerServices.class);
	
	public String getCustomer() {
		String customer = "";
		try {
			RestTemplate restTemplate = new RestTemplate();
			customer = restTemplate.getForObject(LedgerConstant.API_URL + "Customer", String.class);
			log.info(customer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return customer;
	}
	
	public String saveCustomer(Customer customer) {
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
	}
}