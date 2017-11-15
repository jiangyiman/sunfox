package com.sun.fox.uc.server.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SecurityUser extends UcUser implements UserDetails {

    private Set<UcRoles> SysRoles = new HashSet<>(0);// 所对应的角色集合

    public Set<UcRoles> getSysRoles() {
        return SysRoles;
    }

    public void setSysRoles( Set<UcRoles> sysRoles ) {
        SysRoles = sysRoles;
    }

    public SecurityUser( UcUser user, Set<UcRoles> sysRoles ) {
        if (user != null) {
            this.setId(user.getId());
            this.setUsername(user.getUsername());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());
            this.setCreateTime(user.getCreateTime());
            this.setSysRoles(sysRoles);
        }
    }

    /**
     *   重写角色模型
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<UcRoles> userRoles = this.getSysRoles();
        if (userRoles != null) {
            for (UcRoles role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE;
    }

    @Override
    public boolean isEnabled() {
        return super.getActive() == Boolean.TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
