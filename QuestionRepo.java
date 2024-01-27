package com.exam.examserver.repo;

import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entities.exam.Questions;
import com.exam.examserver.entities.exam.Quiz;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer>{

	Set<Questions> findByQuiz(Quiz quiz);

}
