package com.rmgx.assignment.service;

import java.util.List;

import com.rmgx.assignment.dto.CategoryDto;
import com.rmgx.assignment.entity.Category;

public interface CategoryService {
	
	public Category addCategory(CategoryDto categoryDto);
	
	public Category updateCategory(CategoryDto categoryDto, long cat_Id);
	
	public List<Category> getAllCategory();
}
