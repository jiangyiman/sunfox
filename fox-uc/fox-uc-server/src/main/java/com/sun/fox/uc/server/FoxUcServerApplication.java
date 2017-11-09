package com.sun.fox.uc.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  后台用户(管理员)权鉴
 */
@MapperScan(basePackages = {"com.sun.fox.**.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class FoxUcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoxUcServerApplication.class, args);
	}
}
