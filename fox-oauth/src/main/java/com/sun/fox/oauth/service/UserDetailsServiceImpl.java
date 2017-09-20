package com.sun.fox.oauth.service;

import com.sun.fox.member.api.client.MemberInfoClient;
import com.sun.fox.member.api.pojo.MemberInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private MemberInfoClient memberInfoClient;

    @Override
    public UserDetails loadUserByUsername( String loginName) throws UsernameNotFoundException {
        Optional<MemberInfoDto> realUser = Optional.ofNullable(memberInfoClient.getMemberInfoByLoginName(loginName));
        return realUser.map(user -> {
            //Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();
//            return new User(user.getLoginName(),user.getPassword(),grantedAuthorities);
            return new User(user.getLoginName(),user.getPassword(),null);
        }).orElseThrow(() -> new UsernameNotFoundException("用户" + loginName + "不存在!"));
    }
}
