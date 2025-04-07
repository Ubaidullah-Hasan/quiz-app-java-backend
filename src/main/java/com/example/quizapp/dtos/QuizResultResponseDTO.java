package com.example.quizapp.dtos;

import java.time.LocalDateTime;

public class QuizResultResponseDTO {
    private String id;
    private String quizId;
    private String attendeeId;
    private Integer score;
    private LocalDateTime submittedAt;

    public QuizResultResponseDTO(String id, String quizId, String attendeeId, Integer score,
            LocalDateTime submittedAt) {
        this.id = id;
        this.quizId = quizId;
        this.attendeeId = attendeeId;
        this.score = score;
        this.submittedAt = submittedAt;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getQuizId() {
        return quizId;
    }

    public String getAttendeeId() {
        return attendeeId;
    }

    public Integer getScore() {
        return score;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
}
