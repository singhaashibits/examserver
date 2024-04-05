package com.example.demo.service;

import java.util.Set;

import com.example.demo.model.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(int qId);
	public void deleteQuiz(int qId);
}
