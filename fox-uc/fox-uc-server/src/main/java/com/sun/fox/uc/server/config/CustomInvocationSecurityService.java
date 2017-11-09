package com.sun.fox.uc.server.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 就是提供某个资源对应的权限定义
 */
@Service
public class CustomInvocationSecurityService implements FilterInvocationSecurityMetadataSource {


    @Override
    public Collection<ConfigAttribute> getAttributes( Object o ) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports( Class<?> aClass ) {
        return false;
    }
}
