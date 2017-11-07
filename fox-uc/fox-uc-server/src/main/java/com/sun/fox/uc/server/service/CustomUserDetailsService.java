package com.sun.fox.uc.server.service;

import com.sun.fox.uc.server.enums.UserType;
import com.sun.fox.uc.server.mapper.UcUserMapper;
import com.sun.fox.uc.server.model.SecurityUser;
import com.sun.fox.uc.server.model.UcRoles;
import com.sun.fox.uc.server.model.UcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailsService  implements UserDetailsService {

    @Autowired  //业务服务类
    private UcUserMapper ucUserMapper;

    @Override
    public UserDetails loadUserByUsername( String userName) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SysUser中的name作为用户名:
        UcUser user = ucUserMapper.getUcUserByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        if(UserType.SYS_ADMIN.value().equals(user.getType())){
            // 系统用户
        }else{
            // 组织用户 目前就两种
        }
        Set<UcRoles> SysRoles = new HashSet<>(0);// 所对应的角色集合
        // SecurityUser实现UserDetails并将SysUser的name映射为username
        SecurityUser seu = new SecurityUser(user,SysRoles);
        return  seu;
    }
}
