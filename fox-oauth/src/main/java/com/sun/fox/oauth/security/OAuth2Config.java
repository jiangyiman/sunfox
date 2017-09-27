package com.sun.fox.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 为什么不用自动配置。因为/oauth/check_token默认是denyAll.
 * 必须手动设置oauthServer.checkTokenAccess("isAuthenticated()");
 * 才访问能验证Access Token。
 */
@ComponentScan
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }


    @Override
    public void configure( AuthorizationServerEndpointsConfigurer endpoints ) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure( AuthorizationServerSecurityConfigurer oauthServer ) throws Exception {
        oauthServer.checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure( ClientDetailsServiceConfigurer clients ) throws Exception {
        /*clients.inMemory()
                .secret("secretId")
                .authorizedGrantTypes("authorization_code", "client_credentials")
                .scopes("app");*/
        ClientDetailsService clientDetailsService = clientDetails();
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId("client");
        String str = clientDetails.getClientSecret();
        System.out.println("===================client: " + str);
        clients.withClientDetails(clientDetails());
    }
}