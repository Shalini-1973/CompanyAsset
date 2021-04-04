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
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
		Category addCategory = service.addCategory(categoryDto);
		return ResponseEntity.ok(addCategory);
	}
	
	@PostMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestParam(value="category_id") Long cat_Id,@RequestBody CategoryDto categoryDto){
		Category updatedCategory = service.updateCategory(categoryDto,cat_Id);
		return ResponseEntity.ok(updatedCategory);
	}
	
	
	@PostMapping("/getAllcatelogry")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> allCategory = service.getAllCategory();
		return ResponseEntity.ok(allCategory);
	}
}
