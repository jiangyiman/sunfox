package com.sun.fox.discovery.discomery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FoxDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxDiscoveryApplication.class, args);
	}
}
