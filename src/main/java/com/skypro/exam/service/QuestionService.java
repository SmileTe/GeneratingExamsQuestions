package com.skypro.exam.service;

import com.skypro.exam.domain.Question;
import com.skypro.exam.exception.BadRequestException;

import java.util.Collection;

public interface QuestionService {

    public Question add(String question, String answer);
    public Question add(Question question);
    public Question remove(Question question);
    public Question remove(String question);
    public Collection<Question> getAll();
    public Question getRandomQuestion(int amount) throws BadRequestException;


}
