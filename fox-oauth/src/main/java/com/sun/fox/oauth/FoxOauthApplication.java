package com.sun.fox.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class FoxOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxOauthApplication.class, args);
	}
}