package com.example.identityservice.util;

import com.example.identityservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final JwtUtils jwtUtils;

    public JwtUtil(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public String generateToken(User user) {
        return jwtUtils.generateAccessToken(user);
    }
}
