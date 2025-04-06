// package com.example.quizapp.models;

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
// import java.util.List;

// @Document(collection = "quizzes")
// public class Quiz {

//     @Id
//     private String id;

//     private String subject;

//     private List<Question> questions;

//     private String createdBy; // User collection থেকে userId reference

//     private int duration; // কুইজটি দিতে কতক্ষণ সময় লাগবে (মিনিটে)

//     private boolean published; // কুইজটি পাবলিশড কি না

//     public Quiz() {}

//     public Quiz(String subject, List<Question> questions, String createdBy, int duration, boolean published) {
//         this.subject = subject;
//         this.questions = questions;
//         this.createdBy = createdBy;
//         this.duration = duration;
//         this.published = published;
//     }

//     // Getter & Setter

//     public String getId() {
//         return id;
//     }

//     public String getSubject() {
//         return subject;
//     }

//     public void setSubject(String subject) {
//         this.subject = subject;
//     }

//     public List<Question> getQuestions() {
//         return questions;
//     }

//     public void setQuestions(List<Question> questions) {
//         this.questions = questions;
//     }

//     public String getCreatedBy() {
//         return createdBy;
//     }

//     public void setCreatedBy(String createdBy) {
//         this.createdBy = createdBy;
//     }

//     public int getDuration() {
//         return duration;
//     }

//     public void setDuration(int duration) {
//         this.duration = duration;
//     }

//     public boolean isPublished() {
//         return published;
//     }

//     public void setPublished(boolean published) {
//         this.published = published;
//     }
// }


package com.example.quizapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "quizzes")
public class Quiz {
    @Id
    private String id;
    private String subject;
    private List<Question> questions;
    private String createdBy;
    private boolean published;
    private int durationInMinutes;

    public Quiz() {}

    public Quiz(String subject, List<Question> questions, String createdBy, boolean published, int durationInMinutes) {
        this.subject = subject;
        this.questions = questions;
        this.createdBy = createdBy;
        this.published = published;
        this.durationInMinutes = durationInMinutes;
    }

    // getters
    public String getId() { return id; }
    public String getSubject() { return subject; }
    public List<Question> getQuestions() { return questions; }
    public String getCreatedBy() { return createdBy; }
    public boolean isPublished() { return published; }
    public int getDurationInMinutes() { return durationInMinutes; }


    // setters
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}