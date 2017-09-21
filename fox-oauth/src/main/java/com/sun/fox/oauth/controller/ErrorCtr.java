package com.sun.fox.oauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * 自定义的认证错误页
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ErrorCtr {
    private static final Logger log = LoggerFactory.getLogger(ErrorCtr.class);

    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");
        log.info("重定向: {}", uri);
        http://localhost:9098/oauth/authorize?client_id=acme&response_type=code&redirect_uri=http://www.baidu.com
        return "redirect:" + uri + "?error=1";
    }

}
