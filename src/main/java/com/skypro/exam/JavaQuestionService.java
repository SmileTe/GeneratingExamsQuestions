package com.skypro.exam;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    private Set<Question> question ;

    public JavaQuestionService(Set<Question> question) {
        this.question = question;
    }

    @Override
    public Question add(String question, String answer) {

        Question question1 = new Question(question,answer);
        this.add(question1);

        return question1;
    }

    @Override
    public Question add(Question question) {
        this.question.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        this.question.remove(question);
        return question;
    }

    @Override
       public Question remove(String question) {
        List<Question> questions =  this.question.stream().toList();
        for (Question elementQuestions:
             questions) {
            if(elementQuestions.getQuestion().contains(question)){
                this.question.remove(elementQuestions);
                return elementQuestions;
            }
        }

        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return this.question;
    }

    @Override
    public Question getRandomQuestion(int max)  {

        if(max>this.question.size()){
            throw new BadRequestException();
        }
        Random random =new Random();
        Question o = (Question) this.question.toArray()[random.nextInt(0,max)];
        return o;
    }
}
