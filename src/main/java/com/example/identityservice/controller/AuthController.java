package com.example.identityservice.controller;

import com.example.identityservice.dto.RegisterRequest;
import com.example.identityservice.entity.User;
import com.example.identityservice.repository.UserRepository;
import com.example.identityservice.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/test-token")
    public ResponseEntity<?> testToken(@RequestParam String username) {
        return userRepository.findByUsername(username)
                .map(user -> ResponseEntity.ok(jwtUtil.generateToken(user)))
                .orElseGet(() -> ResponseEntity.status(404).body("User not found"));
    }
}
