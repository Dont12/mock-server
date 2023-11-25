package com.example.mockserver.user.repository;

import com.example.mockserver.user.entity.RefreshToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByClientIpAndUserAgent(String clientIp, String userAgent);

    Optional<RefreshToken> findByTokenValue(String tokenValue);
}
