package com.example.demo.model.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String title;
	private String description;
	
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizzes=new LinkedHashSet<>();
	
}