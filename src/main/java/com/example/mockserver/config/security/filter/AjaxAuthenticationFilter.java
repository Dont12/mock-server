package com.example.mockserver.config.security.filter;

import com.example.mockserver.config.security.token.AjaxAuthenticationToken;
import com.example.mockserver.user.dto.UserRequests;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;


public class AjaxAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public AjaxAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response)
        throws AuthenticationException, IOException, ServletException {
        //boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        //if (!isAjax) {
        //    throw new IllegalStateException("Authentication is not supported");
        //}
        UserRequests.LoginRequestDto loginRequestDto = objectMapper.readValue(request.getReader(),
            UserRequests.LoginRequestDto.class);
        if (!StringUtils.hasText(loginRequestDto.getEmail()) || !StringUtils.hasText(
            loginRequestDto.getPassword())) {
            throw new UsernameNotFoundException("Username Or Password is Empty");
        }
        AjaxAuthenticationToken authRequest = AjaxAuthenticationToken.unauthenticated(
            loginRequestDto.getEmail(), loginRequestDto.getPassword());
        setDetails(request, authRequest);
        return getAuthenticationManager().authenticate(authRequest);
    }

    protected void setDetails(HttpServletRequest request, AjaxAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }
}
