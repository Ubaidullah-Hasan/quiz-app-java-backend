package com.example.quizapp.dtos;

import java.util.List;

public class QuizResponseDTO {
    private String id;
    private String subject;
    private List<QuestionDTO> questions;
    private String createdBy;
    private boolean published;
    private int durationInMinutes;

    public QuizResponseDTO(String id, String subject, List<QuestionDTO> questions, String createdBy, boolean published,
            int durationInMinutes) {
        this.id = id;
        this.subject = subject;
        this.questions = questions;
        this.createdBy = createdBy;
        this.published = published;
        this.durationInMinutes = durationInMinutes;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public boolean isPublished() {
        return published;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
