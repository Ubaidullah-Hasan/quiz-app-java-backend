package com.example.quizapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.quizapp.models.QuizResult;

import java.util.List;
import java.util.Optional;

public interface QuizResultRepository extends MongoRepository<QuizResult, String> {
    
    List<QuizResult> findByAttendeeId(String attendeeId);

    Optional<QuizResult> findByQuizIdAndAttendeeId(String quizId, String attendeeId);

    List<QuizResult> findByQuizId(String quizId);
}
