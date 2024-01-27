package com.exam.examserver;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exam.examserver.entities.Role;
import com.exam.examserver.entities.User;
import com.exam.examserver.entities.UserRole;
import com.exam.examserver.services.UserService;


@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("starting code");
		
//		User user=new User();
//		user.setFirstName("Aashi");
//		user.setLastName("Singh");
//		user.setUsername("aashi1200");
//		user.setPassword("abc");
//		user.setEmail("abc@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1=new Role();
//		role1.setRoleId(1);
//		role1.setRoleName("Admin");
//		
//		Set<UserRole> userRoleset=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoleset.add(userRole);
//		
//		User user1=this.userService.createUser(user, userRoleset);
//		System.out.println(user1.getUsername());

		
	}

}
