package com.xcn.eurka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurkaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurkaServerApplication.class, args);
	}
}
