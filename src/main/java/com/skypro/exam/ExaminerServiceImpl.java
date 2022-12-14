package com.skypro.exam;

import java.util.ArrayList;
import java.util.Collection;

public class ExaminerServiceImpl implements ExaminerService{

    public QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = new ArrayList<>();
        while (questions.size()<amount) {
            Question question = this.questionService.getRandomQuestion(amount);
            if(!questions.equals(question)){
                questions.add(question);
            }

        }
        return questions;
    }
}
