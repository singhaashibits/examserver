package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;

@SpringBootApplication
public class ExamportalApplication {
	@Autowired
	private UserService userService;

	public static void main(String[] args){
		SpringApplication.run(ExamportalApplication.class, args);
	}

	
}
