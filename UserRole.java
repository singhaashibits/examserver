package com.exam.examserver.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userRoleId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	@ManyToOne
	private Role role;
}
