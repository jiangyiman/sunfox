package com.sun.fox.discovery.foxdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FoxDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxDiscoveryApplication.class, args);
	}
}
