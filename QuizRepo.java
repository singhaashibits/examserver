package com.exam.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entities.exam.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
