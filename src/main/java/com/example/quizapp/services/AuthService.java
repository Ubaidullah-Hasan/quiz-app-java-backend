package com.example.quizapp.services;


import com.example.quizapp.dtos.*;
import com.example.quizapp.exception.*;
import com.example.quizapp.models.*;
import com.example.quizapp.repositories.*;
import com.example.quizapp.security.*;
import lombok.*;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already in use");
        }
        
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        
        userRepository.save(user);
        
        String jwtToken = jwtUtils.generateJwtToken(user.getEmail());
        
        return AuthResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }
    
    public AuthResponse login(LoginDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        
        if (user.isDeleted()) {
            throw new UserDisabledException("User account is disabled");
        }
        
        String jwtToken = jwtUtils.generateJwtToken(user.getEmail());
        
        return AuthResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }
}