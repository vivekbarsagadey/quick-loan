package com.whiz.quickloan.interceptor;

import java.io.IOException;
import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class XUserAgentInterceptor implements ClientHttpRequestInterceptor{
	
	 @Override
	    public ClientHttpResponse intercept(
	            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
	            throws IOException {

	        HttpHeaders headers = request.getHeaders();
	        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        //headers.add("X-User-Agent", "My App v2.1");
	        return execution.execute(request, body);
	    }

}
