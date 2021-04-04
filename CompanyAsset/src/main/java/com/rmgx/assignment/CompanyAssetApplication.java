package com.rmgx.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompanyAssetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyAssetApplication.class, args);
	}
	
	
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(CompanyAssetApplication.class);

}
