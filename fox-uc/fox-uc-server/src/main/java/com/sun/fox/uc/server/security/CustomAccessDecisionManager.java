package com.sun.fox.uc.server.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 访问决策器，决定某个用户具有的角色，是否有足够的权限去访问某个资源 ;做最终的访问控制决定
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {


    @Override
    public void decide( Authentication authentication, Object o, Collection<ConfigAttribute> collection ) throws AccessDeniedException, InsufficientAuthenticationException {
        if (authentication == null) {
            return;
        }
        Iterator<ConfigAttribute> ite = collection.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ca.getAttribute();
            //String needRole = ((SecurityConfig) ca).getAttribute() 可自定义 扩展用权限定义
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needRole.trim().equals(ga.getAuthority().trim())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports( ConfigAttribute configAttribute ) {
        return Boolean.TRUE;
    }

    @Override
    public boolean supports( Class<?> aClass ) {
        return Boolean.TRUE;
    }
}
