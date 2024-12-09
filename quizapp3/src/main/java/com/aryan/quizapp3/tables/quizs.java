package com.aryan.quizapp3.tables;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class quizs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<questions> question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<questions> getQuestion() {
        return question;
    }

    public void setQuestion(List<questions> question) {
        this.question = question;
    }
}
