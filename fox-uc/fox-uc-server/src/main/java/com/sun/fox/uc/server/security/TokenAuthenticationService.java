package com.sun.fox.uc.server.security;

import com.sun.fox.uc.server.handler.TokenHandler;
import com.sun.fox.uc.server.model.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

@Service
public class TokenAuthenticationService {
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private static final long TEN_DAYS = 1000 * 60 * 60 * 24 * 10;
    private static final String TOKEN_SECRET="88888888";
    private final TokenHandler tokenHandler;

    @Autowired
    public TokenAuthenticationService() {
        tokenHandler = new TokenHandler(DatatypeConverter.parseBase64Binary(TOKEN_SECRET));
    }

    public String addAuthentication( HttpServletResponse response, CustomAuthentication authentication) {
        final SecurityUser user = authentication.getDetails();
        user.setExpires(System.currentTimeMillis() + TEN_DAYS);
        String token = tokenHandler.createTokenForUser(user);
        response.addHeader(AUTH_HEADER_NAME, token);
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            final SecurityUser user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                return new CustomAuthentication(true, user);
            }
        }
        return null;
    }
}