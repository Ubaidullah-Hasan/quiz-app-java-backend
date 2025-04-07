package com.example.quizapp.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Document(collection = "quiz_results")
public class QuizResult {

    @Id
    private String id;

    @NotNull(message = "quizId is required")
    private String quizId;

    @NotNull(message = "attendeeId is required")
    private String attendeeId;

    @NotNull(message = "score is required")
    private Integer score;

    private LocalDateTime submittedAt = LocalDateTime.now(); // default current time

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(String attendeeId) {
        this.attendeeId = attendeeId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
