package com.sun.fox.uc.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


//@Component
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private CustomSecurityMetadataSource customSecurityMetadataSource;

    @Autowired
    private CustomAccessDecisionManager customAccessDecisionManager;

//    @Autowired
//    private AuthenticationManager authenticationManager;
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
       // super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(customAccessDecisionManager);
    }

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
        invoke(fi);
    }

    public void invoke( FilterInvocation fi ) throws IOException, ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.customSecurityMetadataSource;
    }
}
