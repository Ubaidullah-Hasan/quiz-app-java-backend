package com.example.quizapp.dtos;

import com.example.quizapp.models.Result.Answer;
import java.util.List;

public class ResultDTO {
    private String quizId;
    private String quizTitle;
    private int score;
    private int totalQuestions;
    private int timeTaken;
    private String attendeId;
    private List<Answer> correctAnswers;

    // Getters and Setters
    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getAttendeId() {
        return attendeId;
    }

    public void setAttendeId(String attendeId) {
        this.attendeId = attendeId;
    }

    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Answer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}