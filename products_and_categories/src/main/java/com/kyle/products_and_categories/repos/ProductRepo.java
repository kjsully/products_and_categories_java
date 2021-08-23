package com.kyle.products_and_categories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kyle.products_and_categories.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
}
