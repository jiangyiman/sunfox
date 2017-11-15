package com.sun.fox.uc.server.service;

import com.sun.fox.uc.server.enums.UserType;
import com.sun.fox.uc.server.mapper.UcRoleUserMapper;
import com.sun.fox.uc.server.mapper.UcUserMapper;
import com.sun.fox.uc.server.model.SecurityUser;
import com.sun.fox.uc.server.model.UcRoles;
import com.sun.fox.uc.server.model.UcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义 用户数据获取
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired  //业务服务类
    private UcUserMapper ucUserMapper;
    @Autowired
    private UcRoleUserMapper ucRoleUserMapper;

    @Override
    public UserDetails loadUserByUsername( String userName ) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        Set<UcRoles> SysRoles = new HashSet<>(0);// 所对应的角色集合
        UcUser user = ucUserMapper.getUcUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        if (UserType.SYS_ADMIN.value().equals(user.getType())) {
            // 系统用户
            SysRoles = ucRoleUserMapper.getRoleByUserId(user.getId());
        } else {
            // 组织用户 目前就两种
        }
        SecurityUser seu = new SecurityUser(user, SysRoles);
        return seu;
    }

}
