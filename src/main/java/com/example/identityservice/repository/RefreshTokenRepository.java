package com.example.identityservice.repository;

import com.example.identityservice.entity.RefreshToken;
import com.example.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);

    int deleteByUser(User user);
}
