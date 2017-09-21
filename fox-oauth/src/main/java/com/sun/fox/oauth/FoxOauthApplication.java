package com.sun.fox.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication()
@EnableAutoConfiguration()
@EnableDiscoveryClient
public class FoxOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxOauthApplication.class, args);
	}
}
