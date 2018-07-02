package com.whiz.quickloan.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.whiz.quickloan.interceptor.XUserAgentInterceptor;

@Configuration
public class RestTemplateConfig {
	
	@Bean
    public RestTemplate restTemplate() {
		/*ClientHttpRequestFactory requestFactory = new     
			      HttpComponentsClientHttpRequestFactory();*/
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new XUserAgentInterceptor()));
        return restTemplate;
    }

}
