package com.adidas.manish.cityapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityApiApplication.class, args);
	}

}

