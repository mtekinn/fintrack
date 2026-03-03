package com.example.fintrack.controller;

import com.example.fintrack.dto.LoginRequest;
import com.example.fintrack.dto.LoginResponse;
import com.example.fintrack.entity.User;
import com.example.fintrack.repository.UserRepository;
import com.example.fintrack.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Şifre yanlış");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
