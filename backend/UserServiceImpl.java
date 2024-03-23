package com.example.demo.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//CREATING USER
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("USER IS ALREADY THERE");
			throw new Exception("user already present");
		}
		else {
			//USER CREATE
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			local=this.userRepository.save(user);
			
		}
		return local;
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(userName);
	}

	@Override
	public void deleteUserById(long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}

}