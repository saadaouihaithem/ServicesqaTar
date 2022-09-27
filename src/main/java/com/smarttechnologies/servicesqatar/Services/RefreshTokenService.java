package com.smarttechnologies.servicesqatar.Services;

import com.smarttechnologies.servicesqatar.Entities.RefreshToken;
import com.smarttechnologies.servicesqatar.Exception.SpringRedditException;
import com.smarttechnologies.servicesqatar.Repositories.RefreshTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;



    @Service
    @AllArgsConstructor
    @Transactional
    public class RefreshTokenService {

        private final RefreshTokenRepository refreshTokenRepository;

        public RefreshToken generateRefreshToken() {
            RefreshToken refreshToken = new RefreshToken();
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken.setCreatedDate(Instant.now());

            return refreshTokenRepository.save(refreshToken);
        }

        void validateRefreshToken(String token) {
            refreshTokenRepository.findByToken(token)
                    .orElseThrow(() -> new SpringRedditException("Invalid refresh Token"));
        }

        public void deleteRefreshToken(String token) {
            refreshTokenRepository.deleteByToken(token);
        }
}
