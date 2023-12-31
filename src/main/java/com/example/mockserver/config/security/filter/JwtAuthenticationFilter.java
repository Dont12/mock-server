package com.example.mockserver.config.security.filter;

import com.example.mockserver.common.util.cookie.CookieUtil;
import com.example.mockserver.config.security.token.JwtAuthenticationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.springframework.core.log.LogMessage;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder
        .getContextHolderStrategy();

    private final AuthenticationManager authenticationManager;
    private final AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
        AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource) {
        this.authenticationManager = authenticationManager;
        this.authenticationDetailsSource = authenticationDetailsSource;
    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.authenticationManager, "authenticationManager must be specified");
        Assert.notNull(this.authenticationDetailsSource,
            "authenticationDetailsSource must be specified");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws ServletException, IOException {
        if (this.securityContextHolderStrategy.getContext().getAuthentication() != null) {
            this.logger.debug(LogMessage
                .of(() ->
                    "SecurityContextHolder not populated with jwt token, as it already contained: '"
                        + this.securityContextHolderStrategy.getContext().getAuthentication()
                        + "'"));
            chain.doFilter(request, response);
            return;
        }
        Optional<Cookie> accessToken = CookieUtil.getCookie(request, "access-token");
        Optional<Cookie> refreshToken = CookieUtil.getCookie(request, "refresh-token");
        if (accessToken.isPresent()) {
            JwtAuthenticationToken jwtAuth = JwtAuthenticationToken.unauthenticated(
                accessToken.get().getValue(),
                refreshToken.isPresent() ? refreshToken.get().getValue() : "empty");
            setDetails(request, jwtAuth);
            // Attempt authentication via AuthenticationManager
            try {
                Authentication authResult = this.authenticationManager.authenticate(jwtAuth);
                SecurityContext context = this.securityContextHolderStrategy.createEmptyContext();
                context.setAuthentication(authResult);
                this.securityContextHolderStrategy.setContext(context);
                onSuccessfulAuthentication(request, response, authResult);
                this.logger.debug(
                    LogMessage.of(() -> "SecurityContextHolder populated with jwt token: '"
                        + this.securityContextHolderStrategy.getContext().getAuthentication()
                        + "'"));
            } catch (AuthenticationException ex) {
                this.logger.debug(LogMessage
                        .format(
                            "SecurityContextHolder not populated with jwt token, "
                                + "as AuthenticationManager rejected Authentication returned "
                                + "by JwtProvider: '%s'; "
                                + "invalidating jwt token", jwtAuth),
                    ex);
                onUnsuccessfulAuthentication(request, response, ex);
            }
        }
        chain.doFilter(request, response);
    }

    protected void setDetails(HttpServletRequest request, JwtAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    protected void onSuccessfulAuthentication(HttpServletRequest request,
        HttpServletResponse response, Authentication authResult) {
        if (authResult instanceof JwtAuthenticationToken jwtAuthToken
            && jwtAuthToken.isRegenerated()) {
            CookieUtil.addCookie(response, "access-token", jwtAuthToken.getNewAccessToken(),
                60 * 24);
            CookieUtil.addCookie(response, "refresh-token", jwtAuthToken.getNewRefreshToken(),
                60 * 60 * 24);
        }
    }

    protected void onUnsuccessfulAuthentication(HttpServletRequest request,
        HttpServletResponse response, AuthenticationException failed) {
    }
}
