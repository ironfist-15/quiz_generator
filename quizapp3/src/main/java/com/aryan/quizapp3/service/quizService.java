package com.aryan.quizapp3.service;

import com.aryan.quizapp3.repositories.questionRepository;
import com.aryan.quizapp3.repositories.quizRepository;
import com.aryan.quizapp3.tables.UserResponse;
import com.aryan.quizapp3.tables.questions;
import com.aryan.quizapp3.tables.questionwrapper;
import com.aryan.quizapp3.tables.quizs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {

    @Autowired
    quizRepository quizrepository;

    @Autowired
    questionRepository questionrepository;

    public String createQuiz(String category, int numq, String title) {

        List<questions> question=questionrepository.fetchproperquiz(category,numq);

        quizs quiz=new quizs();
        quiz.setTitle(title);
        quiz.setQuestion(question);
        quizrepository.save(quiz);
        return "quiz is created";

    }

    public String deletequizs() {
        quizrepository.deleteAll();
        return "quizdeleted";
    }


    public List<questionwrapper> attemptquiz(Integer id) {
        Optional<quizs> quiz=quizrepository.findById(id); // we have the quiz with us which is mapped to the questions in quiz

        List<questions> questionfromdb=quiz.get().getQuestion(); //all the questions present with the quiz
        //convert all questions with the quiz id to qestion wrapper


        List<questionwrapper> userquestions=new ArrayList<>();

        for(questions q:questionfromdb){
            questionwrapper qw=new questionwrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            userquestions.add(qw);
        }


        return userquestions;
    }


    public Integer submitquiz(Integer id, List<UserResponse> resp) {
        Optional<quizs> quiz = quizrepository.findById(id);
        List<questions> question = quiz.get().getQuestion(); // Fetch all questions for the quiz

        int i = 0;
        int correct = 0;

        for (UserResponse response : resp) {
            // Log response and correct answer to verify the comparison
            System.out.println("Question ID: " + question.get(i).getId());
            System.out.println("User Response: " + response.getResponse());
            System.out.println("Correct Answer: " + question.get(i).getAnswer());

            if (response.getResponse().equals(question.get(i).getAnswer())) {
                correct++;
            }
            i++;
        }

        return correct;
    }

}
