package com.sun.fox.uc.server.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLogoutHandler  implements LogoutHandler {
    @Override
    public void logout( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication ) {
        System.out.printf(" logout ..............");
    }
}
