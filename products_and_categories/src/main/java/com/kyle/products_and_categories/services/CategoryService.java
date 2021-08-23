package com.kyle.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.products_and_categories.models.Category;
import com.kyle.products_and_categories.repos.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo cateRepo;
	
//	READ ALL
	public List<Category> allCategories(){
		return cateRepo.findAll();
	}
//	CREATE
	public Category createCategory(Category c) {
		return cateRepo.save(c);
	}
//	UPDATE
	public Category updateCategory(Category c) {
		return cateRepo.save(c);
	}
//	READ ONE
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = cateRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
//	DELETE
	public void deleteCategory(Long id) {
		cateRepo.deleteById(id);
	}
}