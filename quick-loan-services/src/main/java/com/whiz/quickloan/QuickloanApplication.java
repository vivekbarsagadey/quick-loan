package com.whiz.quickloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickloanApplication {

	public static boolean blockChainENabled = true;
	public static void main(String[] args) {
		SpringApplication.run(QuickloanApplication.class, args);
	}
}