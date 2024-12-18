package com.aryan.quizapp3.repositories;

import com.aryan.quizapp3.tables.quizs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizRepository extends JpaRepository<quizs,Integer> {

}
