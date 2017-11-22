package com.sun.fox.uc.server.config;

import com.sun.fox.uc.server.handler.CustomAuthenticationFailureHandler;
import com.sun.fox.uc.server.handler.CustomAuthenticationSuccessHandler;
import com.sun.fox.uc.server.handler.CustomLogoutHandler;
import com.sun.fox.uc.server.security.*;
import com.sun.fox.uc.server.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

/**
 * spring security  配置目录
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;


    /**
     * 加载配置项
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        CustomAuthenticationFilter upFilter = new CustomAuthenticationFilter(tokenAuthenticationService);
        upFilter.setAuthenticationManager(this.authenticationManager());
        upFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        upFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        //支持token的验证
        AuthenticationWithTokenFilter withTokenFilter = new AuthenticationWithTokenFilter("/user/**");
        withTokenFilter.setTokenService(tokenAuthenticationService);
        http
                .addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class)//在正确的位置添加我们自定义的过滤器
                .authorizeRequests()
                .antMatchers("/main").permitAll()//访问：/home 无需登录认证权限
                .anyRequest().authenticated() //其他所有资源都需要认证，登陆后访问
                .and()
                .formLogin()//登录配置
                .loginPage("/login")
                .successForwardUrl("/index")
                .permitAll()
                .and()
                .logout()//退出配置
                .logoutSuccessUrl("/main")
                .addLogoutHandler(new CustomLogoutHandler())
                .permitAll()
                .and()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
                .rememberMe()
                .tokenValiditySeconds(1209600);
                /*.and()
                .exceptionHandling()//异常处理机制
                .defaultAuthenticationEntryPointFor(new AjaxAuthenticationEntryPoint(), new AjaxRequestMatcher()).and()
                .csrf()
                .disable()
                .addFilterBefore(upFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(withTokenFilter, SecurityContextHolderAwareRequestFilter.class);*/

    }

    @Override
    public void configure( WebSecurity web ) throws Exception {
        super.configure(web);
    }

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    /**
     * 密码操作
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 验证身份失败处理
     *
     * @return
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        String failureUrl = "/.";
        return new CustomAuthenticationFailureHandler(failureUrl);
    }

    /**
     *  验证身份成功处理
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        String successfulUrl = "/index";
        return new CustomAuthenticationSuccessHandler(successfulUrl, this.tokenAuthenticationService);
    }
}
