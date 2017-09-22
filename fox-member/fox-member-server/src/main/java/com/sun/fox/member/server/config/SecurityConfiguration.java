package com.sun.fox.member.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    //不需要权限控制的URL
    public void configure( WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/info", "/error");
    }


}
