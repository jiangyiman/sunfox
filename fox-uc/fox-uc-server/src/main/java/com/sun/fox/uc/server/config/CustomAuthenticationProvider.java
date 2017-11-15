package com.sun.fox.uc.server.config;

import com.sun.fox.uc.server.model.SecurityUser;
import com.sun.fox.uc.server.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *  用户校验
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        String loginName = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> grantedAuth = new ArrayList<>();
        if (vaildateUser(loginName, password, grantedAuth)) {
            Authentication auth = new UsernamePasswordAuthenticationToken(loginName, password, grantedAuth);
            return auth;
        } else {
            return null;
        }
    }

    public boolean vaildateUser(String loginName, String password, List<GrantedAuthority> grantedAuths) {
        SecurityUser user = (SecurityUser)customUserDetailsService.loadUserByUsername(loginName);
        if (user == null || loginName == null || password == null) {
            return false;
        }
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);//将密码加密 可以先设置初始密码：000000
         //  校验用户名和密码 以及权限
       /* if (user.getPassword().equals(bc.encode(password)) && user.getActive().equals(UserStatus.NORMAL)) {
            Set<UcRoles> roles = user.getSysRoles();
           *//* if (roles.isEmpty()) {
                grantedAuths.add(new SimpleGrantedAuthority(RoleType.USER.name()));
            }
            for (UcRoles role : roles) {
                grantedAuths.add(new SimpleGrantedAuthority(role.get().name()));
               // logger.debug("username is " + loginName + ", " + role.getRoleType().name());
            }*//*
            return true;
        }*/
        return false;
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
