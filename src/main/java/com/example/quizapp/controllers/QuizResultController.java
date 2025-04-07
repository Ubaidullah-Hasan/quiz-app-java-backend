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

    // GET all results by attendeeId
    @GetMapping("/attendee/{attendeeId}")
    public ResponseEntity<List<QuizResultResponseDTO>> getResultsByAttendeeId(@PathVariable String attendeeId) {
        List<QuizResultResponseDTO> results = quizResultService.getResultsByAttendeeId(attendeeId);
        return ResponseEntity.ok(results);
    }

    // GET single result by quizId and attendeeId
    @GetMapping("/quiz/{quizId}/attendee/{attendeeId}")
    public ResponseEntity<QuizResultResponseDTO> getResultByQuizIdAndAttendeeId(
            @PathVariable String quizId,
            @PathVariable String attendeeId) {
        QuizResultResponseDTO result = quizResultService.getResultByQuizIdAndAttendeeId(quizId, attendeeId);
        return ResponseEntity.ok(result);
    }

}
