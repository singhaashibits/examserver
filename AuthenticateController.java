package com.exam.examserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.config.JwtUtils;
import com.exam.examserver.entities.JwtRequest;
import com.exam.examserver.entities.JwtResponse;
import com.exam.examserver.entities.User;
import com.exam.examserver.serviceImpl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//return the details of current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
		
	}

}
