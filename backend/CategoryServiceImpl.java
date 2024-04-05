package com.example.demo.service.impl;

import java.util.LinkedHashSet;
import java.util.Locale.Category;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategory(int cId) {
		// TODO Auto-generated method stub
		return this.categoryRepo.findById(cId).get();
	}

	@Override
	public void deleteCategory(int cId) {
		// TODO Auto-generated method stub
//		Category category=new Category();
//		category.setCid(cId);
//		this.categoryRepo.delete(category);
	}

}

