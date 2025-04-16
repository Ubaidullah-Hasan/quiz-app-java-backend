package com.example.quizapp.controllers;

import com.example.quizapp.dtos.ResultDTO;
import com.example.quizapp.models.Result;
import com.example.quizapp.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/result-submissions")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping
    public ResponseEntity<Result> saveResult(@RequestBody ResultDTO resultDTO) {
        Result savedResult = resultService.saveResult(resultDTO);
        return ResponseEntity.ok(savedResult);
    }

    @GetMapping("/user/{attendeId}")
    public ResponseEntity<List<Result>> getResultsByUser(@PathVariable String attendeId) {
        return ResponseEntity.ok(resultService.getResultsByUser(attendeId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Result>> getResultsByQuiz(@PathVariable String quizId) {
        return ResponseEntity.ok(resultService.getResultsByQuiz(quizId));
    }
}