package com.example.quizapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

public class QuizRequestDTO {
    @NotBlank(message = "Subject is required")
    private String subject;

    @NotEmpty(message = "At least 1 question is required")
    @Size(min = 10, max = 10, message = "Exactly 10 questions required")
    private List<QuestionDTO> questions;

    @NotBlank(message = "CreatedBy (User ID) is required")
    private String createdBy;

    private boolean published;
    private int durationInMinutes;

    // getters & setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
