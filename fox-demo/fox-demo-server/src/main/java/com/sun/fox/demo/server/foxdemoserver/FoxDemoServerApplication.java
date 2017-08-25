package com.sun.fox.demo.server.foxdemoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FoxDemoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxDemoServerApplication.class, args);
	}
}
