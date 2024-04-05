package com.example.demo.service;

import java.util.Locale.Category;
import java.util.Set;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(int cId);
	public void deleteCategory(int cId);
}
