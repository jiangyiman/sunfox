package com.sun.fox.uc.server.security;

import com.sun.fox.uc.server.mapper.UcRoleMenuMapper;
import com.sun.fox.uc.server.model.UcRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色访问
 */
@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    /**
     * 缓存 数据
     */
    public static  List<UcRoleMenu> UC_ROLE_MENUS = Collections.synchronizedList(new ArrayList<>());


    @Autowired
    private UcRoleMenuMapper ucRoleMenuMapper;


    @Override
    public Collection<ConfigAttribute> getAttributes( Object object ) throws IllegalArgumentException {
        String url = ((FilterInvocation)object).getRequestUrl();
        //查询所有的url和角色的对应关系
        if(UC_ROLE_MENUS == null){
            UC_ROLE_MENUS =  ucRoleMenuMapper.selectAll();
        }
        //匹配所有的url，并对角色去重
        Set<String> roles = new HashSet<>();
       /* for(UcRoleMenu ru : UC_ROLE_MENUS){
           *//* if (urlMatcher.pathMatchesUrl(ru.getMenuUrl(), url)) {
                roles.add(ru.getRoleCode());
            }*//*
        }*/
        Collection<ConfigAttribute> cas = new ArrayList<>();
        roles.forEach(role->cas.add(new SecurityConfig(role)));
        return cas;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports( Class<?> aClass ) {
        return Boolean.TRUE;
    }
}
