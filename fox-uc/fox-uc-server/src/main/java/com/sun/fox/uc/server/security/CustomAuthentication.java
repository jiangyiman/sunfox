package com.sun.fox.uc.server.security;

import com.sun.fox.uc.server.model.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 用户的登录信息
 * 和用户权限信息
 */
public class CustomAuthentication implements Authentication {
    private boolean authenticated = false;
    private SecurityUser userDetails;

    public CustomAuthentication( boolean authenticated, SecurityUser userDetails ) {
        this.authenticated = authenticated;
        this.userDetails = userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public SecurityUser getDetails() {
        return this.userDetails;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated( boolean isAuthenticated ) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userDetails.getNikeName();
    }
}
