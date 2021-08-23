package com.kyle.products_and_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.products_and_categories.models.Product;
import com.kyle.products_and_categories.repos.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo prodRepo;
	
//	READ ALL
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
//	CREATE
	public Product createProduct(Product p) {
		return prodRepo.save(p);
	}
//	UPDATE
	public Product updateProduct(Product p) {
		return prodRepo.save(p);
	}
//	READ ONE
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = prodRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
//	DELETE
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}
}