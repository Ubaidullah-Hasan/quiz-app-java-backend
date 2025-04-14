package com.example.quizapp.controllers;

import com.example.quizapp.dtos.QuizRequestDTO;
import com.example.quizapp.dtos.QuizResponseDTO;
import com.example.quizapp.services.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponseDTO> createQuiz(@Valid @RequestBody QuizRequestDTO quizRequestDTO) {
        QuizResponseDTO response = quizService.createQuiz(quizRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDTO>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> getQuizById(@PathVariable String id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizResponseDTO> updateQuiz(@PathVariable String id,
            @Valid @RequestBody QuizRequestDTO quizRequestDTO) {
        return ResponseEntity.ok(quizService.updateQuiz(id, quizRequestDTO));
    }

    @PatchMapping("/{id}/published")
    public ResponseEntity<QuizResponseDTO> updatePublishedStatus(@PathVariable String id,
            @RequestParam boolean published) {
        return ResponseEntity.ok(quizService.updatePublishedStatus(id, published));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable String id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok("Quiz deleted successfully.");
    }
}