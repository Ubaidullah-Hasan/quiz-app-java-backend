package com.example.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // ✅ No need for @ComponentScan manually
public class QuizAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizAppApplication.class, args);
    }
}
