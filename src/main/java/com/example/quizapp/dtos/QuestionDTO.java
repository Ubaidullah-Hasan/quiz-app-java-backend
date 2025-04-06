package com.example.quizapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

public class QuestionDTO {
    @NotBlank(message = "Question text is required")
    private String questionText;

    @NotEmpty(message = "Options are required")
    @Size(min = 4, max = 4, message = "Exactly 4 options required")
    private List<String> options;

    @NotBlank(message = "Correct answer is required")
    private String correctAnswer;

    // ✅ Constructor যোগ করো
    public QuestionDTO(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters & Setters
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
