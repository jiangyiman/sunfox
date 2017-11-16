package com.sun.fox.uc.server.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  异常处理返回值 当AjaxRequestMatcher 是否输出
 */
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public AjaxAuthenticationEntryPoint() {
        super();
    }

    @Override
    public void commence( HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2 )
            throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized.");

    }

}