package com.trainingapps.bedavailabilty.bookingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
	    SpringApplication.run(BookingApplication.class, args);

	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
