package com.aryan.quizapp3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index"; // This returns the "index.html" template from the "templates" folder.
    }

    @GetMapping("/questionwork")
    public String questionoperations(){
        return "questionoperations";
    }

    @GetMapping("/quizwork")
    public String quizwork(){
        return "quizoperations";
    }

}
