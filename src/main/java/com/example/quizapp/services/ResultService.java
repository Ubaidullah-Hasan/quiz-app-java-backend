package com.example.quizapp.services;

import com.example.quizapp.dtos.ResultDTO;
import com.example.quizapp.models.Result;
import com.example.quizapp.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Result saveResult(ResultDTO resultDTO) {
        Result result = new Result();
        result.setQuizId(resultDTO.getQuizId());
        result.setQuizTitle(resultDTO.getQuizTitle());
        result.setScore(resultDTO.getScore());
        result.setTotalQuestions(resultDTO.getTotalQuestions());
        result.setTimeTaken(resultDTO.getTimeTaken());
        result.setAttendeId(resultDTO.getAttendeId());
        result.setCorrectAnswers(resultDTO.getCorrectAnswers());

        return resultRepository.save(result);
    }

    public List<Result> getResultsByUser(String attendeId) {
        return resultRepository.findByAttendeId(attendeId);
    }

    public List<Result> getResultsByQuiz(String quizId) {
        return resultRepository.findByQuizId(quizId);
    }
}