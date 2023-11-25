package com.example.mockserver.config.security;

import com.example.mockserver.config.security.exception.AjaxAuthenticationEntryPoint;
import com.example.mockserver.config.security.filter.AjaxAuthenticationFilter;
import com.example.mockserver.config.security.filter.AjaxAuthenticationFilterConfigurer;
import com.example.mockserver.config.security.filter.JwtAuthenticationFilter;
import com.example.mockserver.config.security.handler.AjaxAuthenticationFailureHandler;
import com.example.mockserver.config.security.handler.AjaxAuthenticationSuccessHandler;
import com.example.mockserver.config.security.provider.AjaxAuthenticationProvider;
import com.example.mockserver.config.security.provider.JwtProvider;
import com.example.mockserver.config.security.service.AjaxUserDetailService;
import com.example.mockserver.config.security.service.RefreshTokenService;
import com.example.mockserver.config.security.token.AuthenticationDetails;
import com.example.mockserver.config.security.token.UserPrincipal;
import com.example.mockserver.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private String frontUrlLocal = "http://localhost:3000";

    private static final String loginProcUrl = "/auth/login";

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String[] H2_PAGE = {
        "/h2-console/**"
    };
    private static final String[] SIGNUP_LOGIN = {
        "/users", "/auth/login", "/auth/logout"
    };
    private static final String[] MY_PAGE = {
        "/users", "/products", "/products/{id}"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher(request -> true);

        http
            .httpBasic(HttpBasicConfigurer::disable)
            .formLogin(FormLoginConfigurer::disable)
            .cors(httpSecurityCorsConfigurer ->
                httpSecurityCorsConfigurer
                    .configurationSource(corsConfigurationSource())
            )
            .csrf(CsrfConfigurer::disable)
            .sessionManagement(sessionManagementConfigurer ->
                sessionManagementConfigurer
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http
            .authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                    .requestMatchers(
                        Arrays.stream(H2_PAGE)
                            .map(AntPathRequestMatcher::new)
                            .toArray(AntPathRequestMatcher[]::new)
                    ).permitAll()
                    .requestMatchers(
                        Arrays.stream(SIGNUP_LOGIN)
                            .map(AntPathRequestMatcher::new)
                            .toArray(AntPathRequestMatcher[]::new)
                    ).permitAll()
                    .requestMatchers(
                        Arrays.stream(MY_PAGE)
                            .map(AntPathRequestMatcher::new)
                            .toArray(AntPathRequestMatcher[]::new)
                    ).permitAll()
                    .anyRequest().authenticated());

        http
            .apply(
                new AjaxAuthenticationFilterConfigurer(new AjaxAuthenticationFilter(loginProcUrl),
                    loginProcUrl))
            .setAuthenticationManager(authenticationManager())
            .successHandlerAjax(
                new AjaxAuthenticationSuccessHandler(objectMapper, jwtProvider, refreshTokenService))
            .failureHandlerAjax(new AjaxAuthenticationFailureHandler())
            .setAuthenticationDetailsSource(authenticationDetailsSource())
            .loginProcessingUrl(loginProcUrl);

        http
            .addFilterBefore(
                new JwtAuthenticationFilter(authenticationManager(), authenticationDetailsSource()),
                AnonymousAuthenticationFilter.class);

        http
            .anonymous((anonymous) ->
                anonymous
                    .principal(new UserPrincipal(null, "anonymous")));

        http
            .exceptionHandling((exceptionHandling) ->
                exceptionHandling
                    .authenticationEntryPoint(new AjaxAuthenticationEntryPoint())
            );

        http
            .headers(
                httpSecurityHeadersConfigurer ->
                    httpSecurityHeadersConfigurer.frameOptions(FrameOptionsConfig::sameOrigin));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOriginPattern("*");
//        corsConfiguration.addAllowedOrigin(frontUrl);
//        corsConfiguration.addAllowedOrigin(gatewayUrl);
//        corsConfiguration.addAllowedOrigin(frontUrlLocal);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new NullSecurityContextRepository();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationDetailsSource<HttpServletRequest,
        WebAuthenticationDetails> authenticationDetailsSource() {
        return context -> new AuthenticationDetails(context);
    }

    @Bean
    public AjaxAuthenticationProvider authenticationProvider(AuthenticationManagerBuilder auth,
                                                             JwtProvider jwtProvider) {
        AjaxAuthenticationProvider ajaxAuthenticationProvider = new AjaxAuthenticationProvider(
            ajaxUserDetailService(), passwordEncoder());
        auth.authenticationProvider(ajaxAuthenticationProvider).authenticationProvider(jwtProvider);
        return ajaxAuthenticationProvider;
    }

    @Bean
    public AjaxUserDetailService ajaxUserDetailService() {
        return new AjaxUserDetailService(userRepository);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
