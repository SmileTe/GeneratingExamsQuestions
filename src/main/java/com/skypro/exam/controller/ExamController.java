package com.skypro.exam.controller;

import com.skypro.exam.domain.Question;
import com.skypro.exam.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping()
public class ExamController {
   private  ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return this.service.getQuestions(amount);
    }
}
