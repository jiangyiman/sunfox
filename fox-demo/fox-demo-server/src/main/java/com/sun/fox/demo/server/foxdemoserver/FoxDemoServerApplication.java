package com.sun.fox.demo.server.foxdemoserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class FoxDemoServerApplication {

	private static final Logger log = LoggerFactory.getLogger(FoxDemoServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FoxDemoServerApplication.class, args);
	}

	@Autowired
	void setEnviroment(Environment env) {

		log.info("获取配置文件服务器地址：["+env.getProperty("spring.cloud.config.uri")+"]");
		log.info("获取配置文件配置参数前缀:["+env.getProperty("spring.cloud.config.name")+"]");
		log.info("获取配置文件配置参数后缀:["+env.getProperty("spring.cloud.config.profile")+"]");

	}
}
