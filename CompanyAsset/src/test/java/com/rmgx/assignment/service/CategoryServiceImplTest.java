package com.rmgx.assignment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rmgx.assignment.dto.CategoryDto;
import com.rmgx.assignment.entity.Category;
import com.rmgx.assignment.repo.CategoryRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

	
		@MockBean
		private CategoryRepo repository;
		
		@Autowired
		private CategoryService service;
		
		@Test 
		void getAllCategory() {	
			Category cat1=new Category();
			Category cat2=new Category();
			cat1.setId(1);
			cat1.setName("electrical");
			cat2.setId(2);
			cat2.setName("furniture");
			
			when(repository.findAll()).thenReturn(Stream
					.of(cat1,cat2).collect(Collectors.toList()));
			assertEquals(2, service.getAllCategory().size());
		}
		
		@Test
		public void saveCategoryTest() {
			Category cat = new Category(1,"electrical","abcd");
			CategoryDto dto = new CategoryDto();
			dto.setCategory_name("electrical");
			dto.setDescription("abcd");
			when(repository.save(cat)).thenReturn(cat);
			assertEquals(cat, service.addCategory(dto));
		}
	
}
