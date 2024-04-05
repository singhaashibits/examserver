package com.example.demo.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.exam.Questions;
import com.example.demo.model.exam.Quiz;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer>{

	Set<Questions> findByQuiz(Quiz quiz);

}