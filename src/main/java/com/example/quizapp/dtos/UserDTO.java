package com.example.quizapp.dtos;

import com.example.quizapp.models.Role;

public class UserDTO {
    private String id;
    private String name;
    private String email;
    private Role role;
    private boolean isDeleted;

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}