package com.campus2020.restclient;

import com.campus2020.restclient.controller.RestClientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestclientApplication {

	@Bean
	public RestClientController getGetController(){
		return new RestClientController();
	}

	@Bean
	public RestTemplate getRestTemplate() { return new RestTemplate();}

	public static void main(String[] args) {
		SpringApplication.run(RestclientApplication.class, args);
	}


}
