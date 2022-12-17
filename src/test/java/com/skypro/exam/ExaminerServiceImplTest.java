package com.skypro.exam;

import com.skypro.exam.domain.Question;
import com.skypro.exam.service.ExaminerServiceImpl;
import com.skypro.exam.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;

    ExaminerServiceImpl examinerService;
    Set<Question> questions = new HashSet<>();


    @BeforeEach
    public void setUp() {
        questions.add(new Question("question1", "answer 1"));
        questions.add(new Question("question2", "answer 2"));
        questions.add(new Question("question3", "answer 3"));
        questions.add(new Question("question4", "answer 4"));
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void getQuestions() {
        int t = 2;
        Random random = new Random();
        Mockito.when(questionService.getAll())
                .thenReturn(questions);

        Mockito.when(questionService.getRandomQuestion(t))
                .thenReturn((Question) questions.toArray()[0], (Question) questions.toArray()[1]);
        Collection<Question> col = examinerService.getQuestions(t);
        for (Question question :
                col) {
            System.out.println("question = " + question);
        }

//        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
//            int b = 6;
//            Random random1 = new Random();
//            Mockito.when(questionService.getAll())
//                    .thenReturn(questions);
//
//            Mockito.when(questionService.getRandomQuestion(b))
//                    .thenReturn((Question) questions.toArray()[0], (Question) questions.toArray()[1]);
//            Collection<Question> col1 = examinerService.getQuestions(b);
//            for (Question question :
//                    col1) {
//                System.out.println("question = " + question);
//            }
//        });
//        Assertions.assertEquals("запрошено большее количество вопросов", thrown.getMessage());
    }

}




