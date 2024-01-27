package com.exam.examserver.services;

import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import com.exam.examserver.entities.exam.Questions;
import com.exam.examserver.entities.exam.Quiz;

public interface QuestionService {

	public Questions addQuestion(Questions question);
	public Questions updateQuestion(Questions question);
	public Set<Questions> getQuestions();
	public Questions getQuestion(int quesId);
	public Set<Questions> getQuestions(Quiz quiz);
}
