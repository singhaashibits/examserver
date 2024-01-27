package com.exam.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entities.exam.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,  Integer>{

}
