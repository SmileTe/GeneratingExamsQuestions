package com.skypro.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class JavaQuestionController {
    private  QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/exam/java/add")
    public void addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        this.service.add(question1);
    }
    @GetMapping("/exam/java/remove")
    public void removeQuestion(@RequestParam("question") Question question) {
        this.service.remove(question);

    }
    @GetMapping("/exam/java/getAll")
    public Collection<Question> getAllQuestion() {
        return this.service.getAll();
    }


}
