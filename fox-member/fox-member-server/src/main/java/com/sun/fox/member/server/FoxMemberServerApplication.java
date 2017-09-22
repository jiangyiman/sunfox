package com.sun.fox.member.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@MapperScan(basePackages = {"com.sun.fox.**.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableZuulProxy
public class FoxMemberServerApplication {

    public static void main( String[] args ) {
        SpringApplication.run(FoxMemberServerApplication.class, args);
    }
}
