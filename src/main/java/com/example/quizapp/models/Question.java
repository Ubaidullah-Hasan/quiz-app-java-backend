// package com.example.quizapp.models;

// import java.util.List;

// public class Question {

//     private String questionText;
//     private List<String> options;
//     private String correctAnswer;

//     public Question() {
//     }

//     public Question(String questionText, List<String> options, String correctAnswer) {
//         this.questionText = questionText;
//         this.options = options;
//         this.correctAnswer = correctAnswer;
//     }

//     // Getter & Setter

//     public String getQuestionText() {
//         return questionText;
//     }

//     public void setQuestionText(String questionText) {
//         this.questionText = questionText;
//     }

//     public List<String> getOptions() {
//         return options;
//     }

//     public void setOptions(List<String> options) {
//         this.options = options;
//     }

//     public String getCorrectAnswer() {
//         return correctAnswer;
//     }

//     public void setCorrectAnswer(String correctAnswer) {
//         this.correctAnswer = correctAnswer;
//     }
// }


package com.example.quizapp.models;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public Question() {
    }

    public Question(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // getters & setters
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