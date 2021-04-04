package com.rmgx.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmgx.assignment.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	Category findByName(String category_name);

}
