package com.rmgx.assignment.service;

import java.util.List;

import com.rmgx.assignment.dto.CategoryDto;
import com.rmgx.assignment.entity.Category;

public interface CategoryService {
	
	public Category addCategory(CategoryDto categoryDto);	 // method for adding a category
	
	public Category updateCategory(CategoryDto categoryDto, long cat_Id);		// method for updating a category
	
	public List<Category> getAllCategory();					// method for fetching all categories
}
