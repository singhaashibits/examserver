package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.exam.Quiz;
import com.example.demo.repo.QuizRepo;
import com.example.demo.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(int qId) {
		// TODO Auto-generated method stub
		return this.quizRepo.findById(qId).get();
	}

	@Override
	public void deleteQuiz(int qId) {
		// TODO Auto-generated method stub
//		Quiz q=new Quiz();
//		q.setQid(qId);
//		this.quizRepo.delete(q);
	}

}
