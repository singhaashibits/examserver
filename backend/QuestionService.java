package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.exam.Questions;
import com.example.demo.model.exam.Quiz;

public interface QuestionService {

	public Questions addQuestion(Questions question);
	public Questions updateQuestion(Questions question);
	public Set<Questions> getQuestions();
	public Questions getQuestion(int quesId);
	public Set<Questions> getQuestions(Quiz quiz);
}
