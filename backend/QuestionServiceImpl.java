package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.exam.Questions;
import com.example.demo.model.exam.Quiz;
import com.example.demo.repo.QuestionRepo;
import com.example.demo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Questions addQuestion(Questions question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public Questions updateQuestion(Questions question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public Set<Questions> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionRepo.findAll());
	}

	@Override
	public Questions getQuestion(int quesId) {
		// TODO Auto-generated method stub
		return this.questionRepo.findById(quesId).get();
	}

	@Override
	public Set<Questions> getQuestions(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionRepo.findByQuiz(quiz);
	}

	

}
