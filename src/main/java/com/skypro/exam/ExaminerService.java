package com.skypro.exam;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions (int amount);
}
