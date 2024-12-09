package com.aryan.quizapp3.controller;


import com.aryan.quizapp3.service.quizService;
import com.aryan.quizapp3.tables.UserResponse;
import com.aryan.quizapp3.tables.questions;
import com.aryan.quizapp3.tables.questionwrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class QuizController {

    @Autowired
    quizService quizservice;

    @PostMapping("create")
    public String createQuiz(@RequestParam String category,@RequestParam int numq,@RequestParam String title){
        return quizservice.createQuiz(category,numq,title);
    }

    @DeleteMapping("quizdelete")
    public String deletequizs(){
        return quizservice.deletequizs();
    }

    @GetMapping("quiz/{id}")
    public List<questionwrapper> attemptquiz(@PathVariable Integer id){
        return quizservice.attemptquiz(id);
    }

    @PostMapping("quiz/submit/{id}")
    public Integer submitquiz(@PathVariable Integer id,@RequestBody List<UserResponse> resp){
        return quizservice.submitquiz(id,resp);
    }



}
