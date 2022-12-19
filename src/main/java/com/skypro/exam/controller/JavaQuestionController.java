package com.skypro.exam.controller;

import com.skypro.exam.domain.Question;
import com.skypro.exam.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        this.service.add(question1);
    }
    @GetMapping("/remove")
    public void removeQuestion(@RequestParam("question") String question) {
          this.service.remove(question);

    }
    @GetMapping("/getAll")
    public Collection<Question> getAllQuestion() {
        return this.service.getAll();
    }


}
