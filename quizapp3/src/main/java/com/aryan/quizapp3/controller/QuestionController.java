package com.aryan.quizapp3.controller;


import com.aryan.quizapp3.service.QuestionService;
import com.aryan.quizapp3.tables.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController

public class QuestionController {



    @Autowired
    QuestionService questionService;


    @GetMapping("getquestion")  //it means get all rows in the table questions
    public List<questions> getAllquestions(){
       return questionService.getAllQuestionsservice();
    }

    @GetMapping("/category/{category}")
    public List<questions> getbycategory(@PathVariable String category){
        return questionService.getbycategory(category);
    }

    @GetMapping("/id/{id}")
    public questions getbyid(@PathVariable Integer id){
        return questionService.getbyid(id).orElse(null);
    }

    @PostMapping("add")
    public void postquestion(@RequestBody questions question){
         questionService.postquestion(question);
    }

    @DeleteMapping("deleteall")
    public String deleteall(){
        return questionService.deleteall();
    }

    @PutMapping("update/{id}")
    public String updatequestionbyid(@PathVariable Integer id,@RequestParam String newQuestionText){
        return questionService.updatequestionbyid(id,newQuestionText);
    }

    @PostMapping("addmany")
    public String addquestionsmany(@RequestBody List<questions> question){
        return questionService.addquestionsmany(question);
    }







}
