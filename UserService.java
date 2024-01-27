package com.exam.examserver.services;

import java.util.Set;

import com.exam.examserver.entities.User;
import com.exam.examserver.entities.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole>userRoles) throws Exception;
	public User getUser(String userName);
	public void deleteUserById(int userId);
}
