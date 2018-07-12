package com.whiz.quickloan.ledger.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.ledger.LedgerConstant;
import com.whiz.quickloan.ledger.domain.Application;

@Service
public class LedgerApplicationServices {
	
	private static final Logger log = LoggerFactory.getLogger(LedgerApplicationServices.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getApplication() {
		String application = "";
		try {
			//RestTemplate restTemplate = new RestTemplate();
			application = restTemplate.getForObject(LedgerConstant.API_URL + "Applications", String.class);
			log.info(application.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return application;
	}
	
	public String saveApplication(Application application) {
		ResponseEntity<Application> responseApplication = null;
		
		try {
			log.info(application.toString());
			
			/*List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
			interceptors.add(new LoggingRequestInterceptor());
			restTemplate.setInterceptors(interceptors);*/
			//RestTemplate restTemplate = new RestTemplate();

			responseApplication =  restTemplate.postForEntity(LedgerConstant.API_URL + "Applications",application, Application.class);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		return responseApplication.getBody().toString();
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