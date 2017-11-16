package com.sun.fox.uc.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvcAutoConfiguration
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {

        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/").setViewName("index");// 首页
        registry.addViewController("/index").setViewName("index");// 首页
        registry.addViewController("/login").setViewName("login");

    }

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/", "classpath:/public/");
    }

}
