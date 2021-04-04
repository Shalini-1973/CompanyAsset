package com.rmgx.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmgx.assignment.dto.CategoryDto;
import com.rmgx.assignment.entity.Category;
import com.rmgx.assignment.repo.CategoryRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	
	
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryRepo category_repo;;
	
	@Override
	public Category addCategory(CategoryDto categoryDto) {
		Category category=null;
		category = category_repo.findByName(categoryDto.getCategory_name());
		if(category==null) {
			Category newCategory = new Category();
			newCategory.setName(categoryDto.getCategory_name());
			newCategory.setDescription(categoryDto.getDescription());
			category = category_repo.save(newCategory);
		}
		if(category!=null) {
			log.info("category added to the database");
		}else {
			log.info("error in adding category to the database");
		}
		
		return category;
	}

	@Override
	public Category updateCategory(CategoryDto categoryDto, long cat_Id) {
		Category category = category_repo.findById(cat_Id).get();
		category.setName(categoryDto.getCategory_name());
		category.setDescription(categoryDto.getDescription());
		Category updated = category_repo.save(category);
		
		if(updated!=null) {
			log.info("category updated");
		}else {
			log.info("error in updating category to the database");
		}		return updated;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategory = category_repo.findAll();
		System.out.println(allCategory.toString());
		return allCategory;
	}

}
