package com.example.quizapp.dtos;

import com.example.quizapp.models.Role;

public class AuthResponse {
    private String token;
    private String email;
    private String name;
    private Role role;

    // Default constructor
    public AuthResponse() {
    }

    // All arguments constructor
    public AuthResponse(String token, String email, String name, Role role) {
        this.token = token;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Builder class
    public static class Builder {
        private String token;
        private String email;
        private String name;
        private Role role;

        public Builder() {
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(token, email, name, role);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
