package com.skypro.exam;

import com.skypro.exam.domain.Question;
import com.skypro.exam.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class JavaQuestionServiceTest {

    HashSet<Question> questions = new HashSet<>();
     public JavaQuestionService javaQuestionService;


    @BeforeEach
    public void setUp(){
        questions.add(new Question("question1", "answer 1"));
        questions.add(new Question("question2", "answer 2"));
        questions.add(new Question("question3", "answer 3"));
        questions.add(new Question("question4", "answer 4"));
        javaQuestionService = new JavaQuestionService(questions);
    }

    @Test
    public void add() {
        Question question1 = new Question("question 5", "answer 5");
        javaQuestionService.add(question1);
        System.out.println("question1 = " + question1);
    }

    @Test
    public void remove() {
        Question question1 = new Question("question 5", "answer 5");
        javaQuestionService.remove(javaQuestionService.getRandomQuestion(1));
        for (Question question:
                javaQuestionService.getAll()) {
            System.out.println("question = " + question);
        }
    }

    @Test
    public void getAll() {
        for (Question question:
                javaQuestionService.getAll()) {
            System.out.println("question = " + question);
        }
    }

    @Test
    public void getRandomQuestion() {
        Question question1 = javaQuestionService.getRandomQuestion(4);
       // Question question1 = javaQuestionService.getRandomQuestion(5);
            System.out.println("question = " + question1);
    }
}
