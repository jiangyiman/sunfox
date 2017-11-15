package com.sun.fox.uc.server.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by muyz on 2017/11/13.
 */
public class MyLogoutHandler implements LogoutHandler {
    @Override
    public void logout( HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("do logout ......");
    }
}
