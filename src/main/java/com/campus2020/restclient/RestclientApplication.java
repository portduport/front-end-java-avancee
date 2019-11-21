package com.campus2020.restclient;

import com.campus2020.restclient.controller.RestClientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class RestclientApplication {

	@Bean
	public RestClientController getGetController(){
		return new RestClientController();
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() { return new RestTemplate();}

	public static void main(String[] args) {
		SpringApplication.run(RestclientApplication.class, args);
	}


}
