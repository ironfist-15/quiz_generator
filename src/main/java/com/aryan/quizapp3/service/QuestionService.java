package com.aryan.quizapp3.service;

import com.aryan.quizapp3.repositories.questionRepository;
import com.aryan.quizapp3.tables.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    questionRepository questionrepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<questions> getAllQuestionsservice() {
        return questionrepository.findAll();
    }

    public List<questions> getbycategory(String category) {
        return questionrepository.findByCategory(category);
    }

    public Optional<questions> getbyid(Integer id) {
        return questionrepository.findById(id);//.orElse(null);
    }

    public void postquestion(questions question) {
         questionrepository.save(question);

    }

    public String deleteall() {
        questionrepository.deleteAll();
        String resetSequenceQuery = "SELECT setval(pg_get_serial_sequence('questions', 'id'), 1, false)";
        jdbcTemplate.execute(resetSequenceQuery);
        return "deleted";
    }



    public String updatequestionbyid(Integer id, String newQuestionText) {
        Optional<questions> questionOptional = questionrepository.findById(id);
        if (questionOptional.isPresent()) {
            questions question = questionOptional.get();
            question.setQuestion(newQuestionText);
            questionrepository.save(question);
            return "Question updated successfully";
        }
        return "Question not found";
    }

    public String addquestionsmany(List<questions> question) {
        questionrepository.saveAll(question);
        return "many question added!";
    }
}
