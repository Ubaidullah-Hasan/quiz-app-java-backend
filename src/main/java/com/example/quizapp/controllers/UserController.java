package com.example.quizapp.controllers;

import com.example.quizapp.dtos.ErrorResponse;
import com.example.quizapp.dtos.UserDTO;
import com.example.quizapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("email");
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        try {
            UserDTO user = userService.getUserByEmail(email);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("User not found with email: " + email));
        }
    }
}