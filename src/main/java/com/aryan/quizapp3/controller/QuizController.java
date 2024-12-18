package com.aryan.quizapp3.controller;


import com.aryan.quizapp3.service.quizService;
import com.aryan.quizapp3.tables.UserResponse;
import com.aryan.quizapp3.tables.questions;
import com.aryan.quizapp3.tables.questionwrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class QuizController {

    @Autowired
    quizService quizservice;

    @PostMapping("create")
    @ResponseBody
    public Map<String, Integer> createQuiz(@RequestParam String category,
                                           @RequestParam int numq,
                                           @RequestParam String title) {
        Integer quizId = quizservice.createQuiz(category, numq, title);
        Map<String, Integer> response = new HashMap<>();
        response.put("id", quizId);
        return response;  // This will be converted to JSON automatically
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
