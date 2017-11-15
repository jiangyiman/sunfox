package com.sun.fox.uc.server.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by muyz on 2017/11/10.
 */

public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public AjaxAuthenticationEntryPoint() {
    }

    @Override
    public void commence( HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
            throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized.");

    }

}