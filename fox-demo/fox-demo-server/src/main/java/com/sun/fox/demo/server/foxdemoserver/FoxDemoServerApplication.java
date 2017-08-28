package com.sun.fox.demo.server.foxdemoserver;

import com.sun.fox.fk.swagger.properties.SwaggerAutoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(SwaggerAutoConfig.class)
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
		log.info("获取配置文件配置参数:["+env.getProperty("eureka.client.serviceUrl.defaultZone")+"]");
		log.info("获取配置文件配置参数:["+env.getProperty("swagger.pathmapping")+"]");

	}
}
