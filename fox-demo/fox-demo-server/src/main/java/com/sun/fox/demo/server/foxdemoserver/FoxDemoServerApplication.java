package com.sun.fox.demo.server.foxdemoserver;

import com.sun.fox.fk.swagger.properties.SwaggerAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(SwaggerAutoConfig.class)
public class FoxDemoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxDemoServerApplication.class, args);
	}
}
