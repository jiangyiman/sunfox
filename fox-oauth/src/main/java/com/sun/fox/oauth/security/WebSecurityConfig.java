package com.sun.fox.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.sql.DataSource;

@ComponentScan
@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    /**
     * 不需要权限控制的路径
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/hystrix.stream/**", "/info", "/error");
    }


   @Override
   protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
   }

    /**
     * 从数据库获取
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        UserDetails userDetails = userDetailsService().loadUserByUsername("reader");
        System.out.println(userDetails.getPassword());
    }

}
