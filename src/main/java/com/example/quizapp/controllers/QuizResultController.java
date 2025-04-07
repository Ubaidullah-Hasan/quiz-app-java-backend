package com.example.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.quizapp.dtos.QuizResultRequestDTO;
import com.example.quizapp.dtos.QuizResultResponseDTO;
import com.example.quizapp.services.QuizResultService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/results")
public class QuizResultController {

    @Autowired
    private QuizResultService quizResultService;

    @PostMapping
    public ResponseEntity<QuizResultResponseDTO> submitResult(@Valid @RequestBody QuizResultRequestDTO dto) {
        QuizResultResponseDTO result = quizResultService.saveResult(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizResultResponseDTO>> getResultsByQuizId(@PathVariable String quizId) {
        List<QuizResultResponseDTO> results = quizResultService.getResultsByQuizId(quizId);
        return ResponseEntity.ok(results);
    }
}
