package com.example.mockserver.config.security.service;

import com.example.mockserver.config.security.exception.RefreshTokenException;
import com.example.mockserver.config.security.token.AuthenticationDetails;
import com.example.mockserver.config.security.token.UserPrincipal;
import com.example.mockserver.user.entity.RefreshToken;
import com.example.mockserver.user.repository.RefreshTokenRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public boolean isValidRefreshToken(String tokenValue, UserPrincipal principal,
                                       AuthenticationDetails details) throws RefreshTokenException {
        RefreshToken findRefreshToken = refreshTokenRepository.findByTokenValue(tokenValue)
                .orElseThrow(() -> new RefreshTokenException("No Such RefreshToken"));
        return findRefreshToken.getUserId().equals(principal.getId())
                && findRefreshToken.getClientIp().equals(details.getClientIp())
                && findRefreshToken.getUserAgent().equals(details.getUserAgent());
    }

    @Transactional
    public String updateRefreshToken(UserPrincipal principal, AuthenticationDetails details) {
        Long userId = principal.getId();
        String clientIp = details.getClientIp();
        String userAgent = details.getUserAgent();

        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByClientIpAndUserAgent(
                clientIp, userAgent);
        String refreshTokenValue = UUID.randomUUID().toString();
        if (refreshToken.isPresent()) {
            refreshToken.get().update(userId, refreshTokenValue);
            refreshTokenRepository.saveAndFlush(refreshToken.get());
        } else {
            refreshTokenRepository.saveAndFlush(
                    RefreshToken.create(userId, refreshTokenValue, clientIp, userAgent));
        }

        return refreshTokenValue;
    }
}
