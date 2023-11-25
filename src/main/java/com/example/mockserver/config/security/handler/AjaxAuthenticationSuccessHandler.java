package com.example.mockserver.config.security.handler;

import com.example.mockserver.common.util.cookie.CookieUtil;
import com.example.mockserver.config.security.provider.JwtProvider;
import com.example.mockserver.config.security.service.RefreshTokenService;
import com.example.mockserver.config.security.token.AuthenticationDetails;
import com.example.mockserver.config.security.token.UserPrincipal;
import com.example.mockserver.response.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@RequiredArgsConstructor
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
        // access-token
        String accessToken = jwtProvider.generateAccessToken(authentication);

        CookieUtil.addCookie(response, "access-token", accessToken, 60 * 30);

        // refresh-token
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        AuthenticationDetails details = (AuthenticationDetails) authentication.getDetails();
        String refreshTokenValue = refreshTokenService.updateRefreshToken(principal, details);

        CookieUtil.addCookie(response, "refresh-token", refreshTokenValue, 60 * 60 * 24);

        // response
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(response.getWriter(), ResponseBody.ok());
    }
}
