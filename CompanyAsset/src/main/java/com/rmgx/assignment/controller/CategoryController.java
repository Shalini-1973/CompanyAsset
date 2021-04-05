package com.rmgx.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmgx.assignment.dto.CategoryDto;
import com.rmgx.assignment.entity.Category;
import com.rmgx.assignment.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service; 
	
	@PostMapping("/addCategory")		//handle request for adding a category
	public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
		Category addCategory = service.addCategory(categoryDto); //a service method called for adding a category to the database
		return ResponseEntity.ok(addCategory);
	}
	
	@PostMapping("/updateCategory")		//handle request for updating a category
	public ResponseEntity<Category> updateCategory(@RequestParam(value="category_id") Long cat_Id,@RequestBody CategoryDto categoryDto){
		Category updatedCategory = service.updateCategory(categoryDto,cat_Id);//a service method called for updating a category
		return ResponseEntity.ok(updatedCategory);
	}
	
	
	@PostMapping("/getAllcatelogry")							 // handles request for fetching all the categories
	public ResponseEntity<List<Category>> getAllCategory(){	
		List<Category> allCategory = service.getAllCategory();	//a service method called for fetching all the categories stored in database
		return ResponseEntity.ok(allCategory);
	}
}
