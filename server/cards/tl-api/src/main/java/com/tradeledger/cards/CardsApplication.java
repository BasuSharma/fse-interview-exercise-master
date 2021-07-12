package com.tradeledger.cards;

import java.time.Duration;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate; 
import org.slf4j.Logger;

@SpringBootApplication

@ComponentScan(basePackages={"com.tradeledger.cards"})
public class CardsApplication {

	static final Logger logger = 
	        (Logger) LoggerFactory.getLogger(CardsApplication.class);
	@Bean
	public RestTemplate restTemplate(
	        RestTemplateBuilder restTemplateBuilder) {

	    return restTemplateBuilder
	            .setConnectTimeout(Duration.ofSeconds(10))
	            .setReadTimeout(Duration.ofSeconds(10))
	            .build();
	}
	@Bean
	public RestTemplateBuilder restTemplateBuilder() {

	    return new RestTemplateBuilder();
	}

	
	public static void main(String[] args) {
		
		SpringApplication.run(CardsApplication.class, args);
		logger.info("Applicaiton initiated successfully");
	}
	
}
