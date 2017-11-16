package com.sun.fox.uc.server.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理身份验证失败
 */
public class CustomAuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    private String defaultFailureUrl = "";

    public CustomAuthenticationFailureHandler( String defaultFailureUrl ) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

    @Override
    public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException {
        if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            PrintWriter writer = response.getWriter();
            writer.write("{\"code\": -1 , \"message\": \"" + exception.getMessage() + "\"}");
            writer.flush();
            writer.close();
        } else {
            request.setAttribute("exception", exception);
            RequestCache requestCache = new HttpSessionRequestCache();
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest != null) {
                response.sendRedirect(savedRequest.getRedirectUrl());
            } else
                response.sendRedirect(defaultFailureUrl);
        }
    }
}
