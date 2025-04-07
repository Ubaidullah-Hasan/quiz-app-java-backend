package com.example.quizapp.dtos;

import jakarta.validation.constraints.NotNull;

public class QuizResultRequestDTO {

    @NotNull(message = "quizId is required")
    private String quizId;

    @NotNull(message = "attendeeId is required")
    private String attendeeId;

    @NotNull(message = "score is required")
    private Integer score;

    // Getters and Setters
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
}
