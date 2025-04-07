package com.example.quizapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.dtos.QuizResultRequestDTO;
import com.example.quizapp.dtos.QuizResultResponseDTO;
import com.example.quizapp.models.QuizResult;
import com.example.quizapp.repositories.QuizResultRepository;

@Service
public class QuizResultService {

    @Autowired
    private QuizResultRepository quizResultRepository;

    public QuizResultResponseDTO saveResult(QuizResultRequestDTO dto) {
        QuizResult result = new QuizResult();
        result.setQuizId(dto.getQuizId());
        result.setAttendeeId(dto.getAttendeeId());
        result.setScore(dto.getScore());

        QuizResult saved = quizResultRepository.save(result);

        return new QuizResultResponseDTO(
                saved.getId(),
                saved.getQuizId(),
                saved.getAttendeeId(),
                saved.getScore(),
                saved.getSubmittedAt());
    }

    public List<QuizResultResponseDTO> getResultsByQuizId(String quizId) {
        List<QuizResult> results = quizResultRepository.findByQuizId(quizId);

        return results.stream().map(result -> new QuizResultResponseDTO(
                result.getId(),
                result.getQuizId(),
                result.getAttendeeId(),
                result.getScore(),
                result.getSubmittedAt())).collect(Collectors.toList());
    }
}
