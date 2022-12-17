package com.skypro.exam.service;

import com.skypro.exam.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions (int amount);
}
