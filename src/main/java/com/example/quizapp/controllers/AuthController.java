package com.example.quizapp.controllers;

import com.example.quizapp.dtos.LoginDTO;
import com.example.quizapp.dtos.RegisterRequest;
import com.example.quizapp.services.AuthService;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
