package com.sun.fox.uc.server.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.fox.uc.server.model.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证登录名和密码是否匹配
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private TokenAuthenticationService tokenService;

    public CustomAuthenticationFilter( TokenAuthenticationService tokenAuthenticationService) {
        super();
        this.tokenService = tokenAuthenticationService;
    }

    @Override
    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        SecurityUser user = null;
        if ("application/x-www-form-urlencoded".equals(request.getHeader("content-type"))){
            user = new SecurityUser(request.getParameter("username"),request.getParameter("password"));
        } else {
            try {
                user = new ObjectMapper().readValue(request.getInputStream(), SecurityUser.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //组织验证用的token
        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword());
        return getAuthenticationManager().authenticate(loginToken);
    }
}
