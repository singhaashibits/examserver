package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.impl.UserDetailsServiceImpl;

//config class
//it's to switch off the default web application security configuration and add your own.

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter ;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

//calling loadUserByUsername of UserDetailsServiceImpl

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//configuring some endpoints
		//method chaining
		//Cross-Site Request Forgery (CSRF)
		//http. cors(). disable() means that the server is not supporting Cross-Origin Resource Sharing.
		//antMatchers() is used to configure the URL paths which either can be permitted or denied to the user’s http request, 
		//according to the role or the authorization of that particular user.
		
		
		http
		.csrf()
		.disable()   //Calling disable() will disable CSRF protection.
		.cors()
		.disable()
		.authorizeRequests()  //Allows restricting access based on http request
		.antMatchers("/generate-token", "/user/").permitAll()    //anyone can access endpoint without authentication.
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()    //restrict the access for any other endpoint other than PUBLIC_URL, and the user must be authenticated.
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)    //handles authentication exception
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		//each request that comes to your application will pass through your security class and filters.
	}
	
	
	
}





//When a session begins, a cryptographically signed token is generated (usually in the form of a JWT) that encodes the user's ID and the timestamp when the session expires.
//This token is then passed along with future web requests.

//When requests are received, the backend confirms that the token's signature is valid and that it has not expired. 
//This is considered stateless because no database is involved, just cryptography to verify the signature.


//csrf----from changing the user’s info without his knowledge to gaining full access to the user’s account.
//browsers submit cookies to a website whenever a request is made to that website without checking the “origin” of the request.
//This is where CSRF comes into picture.
//The attacker places some code on his website that makes a genuine looking request to the target website. 
//The cookies of the target website will be added by the browser in the request . 
//This will make that forged request a legal one and it’s action will be successfully carried out.




