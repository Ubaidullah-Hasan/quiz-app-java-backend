package com.example.quizapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "results")
public class Result {
    @Id
    private String id;
    private String quizId;
    private String quizTitle;
    private int score;
    private int totalQuestions;
    private int timeTaken;
    private String attendeId;
    private List<Answer> correctAnswers;

    public static class Answer {
        private String question;
        private String correctAnswer;
        private String userAnswer;
        private boolean isCorrect;

        // Getters and Setters for Answer
        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public String getUserAnswer() {
            return userAnswer;
        }

        public void setUserAnswer(String userAnswer) {
            this.userAnswer = userAnswer;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public void setCorrect(boolean isCorrect) {
            this.isCorrect = isCorrect;
        }
    }

    // Getters and Setters for Result
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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