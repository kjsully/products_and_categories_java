package com.kyle.products_and_categories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kyle.products_and_categories.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
}
