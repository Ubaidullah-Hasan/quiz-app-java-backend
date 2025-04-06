package com.example.quizapp.services;

import com.example.quizapp.dtos.*;
import com.example.quizapp.exception.ResourceNotFoundException;
import com.example.quizapp.models.*;
import com.example.quizapp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public QuizResponseDTO createQuiz(QuizRequestDTO dto) {
        List<Question> questionEntities = dto.getQuestions().stream()
                .map(q -> new Question(q.getQuestionText(), q.getOptions(), q.getCorrectAnswer())).toList();

        Quiz quiz = new Quiz(
                dto.getSubject(),
                questionEntities,
                dto.getCreatedBy(),
                dto.isPublished(),
                dto.getDurationInMinutes());

        Quiz savedQuiz = quizRepository.save(quiz);

        return new QuizResponseDTO(
                savedQuiz.getId(),
                savedQuiz.getSubject(),
                dto.getQuestions(),
                savedQuiz.getCreatedBy(),
                savedQuiz.isPublished(),
                savedQuiz.getDurationInMinutes());
    }

    public List<QuizResponseDTO> getAllQuizzes() {
        return quizRepository.findAll().stream()
                .map(quiz -> new QuizResponseDTO(
                        quiz.getId(),
                        quiz.getSubject(),
                        quiz.getQuestions().stream().map(q -> new QuestionDTO(
                                q.getQuestionText(),
                                q.getOptions(),
                                q.getCorrectAnswer())).toList(),
                        quiz.getCreatedBy(),
                        quiz.isPublished(),
                        quiz.getDurationInMinutes()))
                .collect(Collectors.toList());
    }

    public QuizResponseDTO getQuizById(String id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));

        return new QuizResponseDTO(
                quiz.getId(),
                quiz.getSubject(),
                quiz.getQuestions().stream().map(q -> new QuestionDTO(
                        q.getQuestionText(),
                        q.getOptions(),
                        q.getCorrectAnswer())).toList(),
                quiz.getCreatedBy(),
                quiz.isPublished(),
                quiz.getDurationInMinutes());
    }

    public QuizResponseDTO updateQuiz(String id, QuizRequestDTO dto) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));

        quiz.setSubject(dto.getSubject()); 
        quiz.setCreatedBy(dto.getCreatedBy());
        quiz.setDurationInMinutes(dto.getDurationInMinutes());
        quiz.setPublished(dto.isPublished());
        quiz.setQuestions(dto.getQuestions().stream()
                .map(q -> new Question(q.getQuestionText(), q.getOptions(), q.getCorrectAnswer()))
                .collect(Collectors.toList()));

        Quiz updatedQuiz = quizRepository.save(quiz);

        return new QuizResponseDTO(
                updatedQuiz.getId(),
                updatedQuiz.getSubject(),
                dto.getQuestions(),
                updatedQuiz.getCreatedBy(),
                updatedQuiz.isPublished(),
                updatedQuiz.getDurationInMinutes());
    }

    public QuizResponseDTO updatePublishedStatus(String id, boolean published) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));

        quiz.setPublished(published);
        Quiz updatedQuiz = quizRepository.save(quiz);

        return new QuizResponseDTO(
                updatedQuiz.getId(),
                updatedQuiz.getSubject(),
                updatedQuiz.getQuestions().stream().map(q -> new QuestionDTO(
                        q.getQuestionText(),
                        q.getOptions(),
                        q.getCorrectAnswer())).toList(),
                updatedQuiz.getCreatedBy(),
                updatedQuiz.isPublished(),
                updatedQuiz.getDurationInMinutes());
    }

    public void deleteQuiz(String id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));

        quizRepository.delete(quiz);
    }

}
