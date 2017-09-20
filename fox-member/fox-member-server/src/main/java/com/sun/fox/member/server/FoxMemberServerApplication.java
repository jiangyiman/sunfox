package com.sun.fox.member.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(basePackages = {"com.sun.fox.**.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class FoxMemberServerApplication {

    public static void main( String[] args ) {
        SpringApplication.run(FoxMemberServerApplication.class, args);
    }
}
