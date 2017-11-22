package com.sun.fox.uc.server.handler;

import com.sun.fox.uc.server.model.SecurityUser;
import com.sun.fox.uc.server.model.UcUser;
import com.sun.fox.uc.server.security.CustomAuthentication;
import com.sun.fox.uc.server.security.TokenAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 身份验证成功
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    private String successfulUrl;

    public CustomAuthenticationSuccessHandler() {

    }

    public CustomAuthenticationSuccessHandler( String successfulUrl, TokenAuthenticationService tokenService ) {
        this.tokenService = tokenService;
        this.successfulUrl = successfulUrl;
    }

    private TokenAuthenticationService tokenService;

    @Override
    public void onAuthenticationSuccess( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {
        //----这里只要一个用户名即可

        final SecurityUser authenticatedUser = (SecurityUser) authentication.getPrincipal();
        final CustomAuthentication userAuthentication = new CustomAuthentication(true, authenticatedUser);
        //-----实际在向response的headers添加一个认证信息token
        String token = tokenService.addAuthentication(response, userAuthentication);
        //-----写入,在授权阶段使用
        SecurityContextHolder.getContext().setAuthentication(userAuthentication);
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        UcUser userDetails = (UcUser) authentication.getPrincipal();
        //输出登录提示信息
        log.info("管理员 " + userDetails.getUsername() + " 登录");
        log.info("IP :" + getIpAddress(request));
        // 也可以 session 里面添加数据, 或者记录用户的登录时间 登录ip 一些用户信息采集
        if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            PrintWriter writer = response.getWriter();
            writer.write("{\"code\": 0 , \"message\": \"ok\" , \"token\":\"" + token + "\"}");
            writer.flush();
            writer.close();
        } else {
            request.setAttribute("token", token);
            RequestCache requestCache = new HttpSessionRequestCache();
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest != null) {
                response.sendRedirect(savedRequest.getRedirectUrl());
            } else {
                response.sendRedirect(successfulUrl);
            }
        }
    }

    public String getIpAddress( HttpServletRequest request ) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
