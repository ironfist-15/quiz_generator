package com.aryan.quizapp3.repositories;

import com.aryan.quizapp3.tables.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionRepository extends JpaRepository<questions,Integer> {

    List<questions> findByCategory(String category);

    @Query(value="select * from questions q where q.category=:category ORDER BY RANDOM() Limit :numq",nativeQuery = true)
    List<questions> fetchproperquiz(String category, int numq);
}
