package com.example.quizapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.quizapp.models.Quiz;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}
