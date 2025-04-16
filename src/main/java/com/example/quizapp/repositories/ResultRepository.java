package com.example.quizapp.repositories;

import com.example.quizapp.models.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ResultRepository extends MongoRepository<Result, String> {
    List<Result> findByAttendeId(String attendeId);

    List<Result> findByQuizId(String quizId);
}