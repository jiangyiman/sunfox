package com.sun.fox.demo.server.foxdemoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@EnableFeignClients
@SpringCloudApplication
@SpringBootApplication
@EnableEurekaClient
public class FoxDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxDemoServerApplication.class, args);
    }
}
