package com.skypro.exam.service;

import com.skypro.exam.domain.Question;
import com.skypro.exam.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount>this.questionService.getAll().size()){
            throw new BadRequestException(("Bad request"));
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size()<amount) {
            Question question = questionService.getRandomQuestion(amount);
            questions.add(question);
        }
        return questions;
    }

}
