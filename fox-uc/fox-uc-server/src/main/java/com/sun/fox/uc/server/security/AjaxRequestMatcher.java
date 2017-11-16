package com.sun.fox.uc.server.security;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 *  判断请求类型 是否是ajax请求 如果是则返回 true  反之 返回 false
 */
public class AjaxRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Request-With")) ||
                request.getHeader("Accept")!=null &&
                request.getHeader("Accept").contains("application/json");
    }
}
