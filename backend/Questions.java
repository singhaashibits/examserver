package com.example.demo.model.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Questions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int quesId;
	private String content;
	private String image;

	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Quiz quiz;

}