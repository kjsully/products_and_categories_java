package com.kyle.products_and_categories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.products_and_categories.models.Category;
import com.kyle.products_and_categories.models.Product;
import com.kyle.products_and_categories.services.CategoryService;
import com.kyle.products_and_categories.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService prodServ;
	@Autowired
	private CategoryService cateServ;
	
	@GetMapping("/")
	public String index (Model model) {
		List<Product> allProducts = prodServ.allProducts();
		model.addAttribute("allProducts", allProducts);
		List<Category> allCategories = cateServ.allCategories();
		model.addAttribute("allCategories", allCategories);
		return "index.jsp";
	}

//------CREATE PRODUCT-------
	
	@GetMapping("/products/new")
	public String newProductPage(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}

	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute Product product, BindingResult res) {
		if (res.hasErrors()) {
			return "/products/new.jsp";
		} else {
			prodServ.createProduct(product);
			return "redirect:/";
		}
	}

//	----- CREATE CATEGORY ------
	@GetMapping("/categories/new")
	public String newCategoryPage(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}

	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute Category category, BindingResult res) {
		if (res.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			cateServ.createCategory(category);
			return "redirect:/";
		}
	}
	
	
	
	

//	--- SHOW ONE PRODUCT -----
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product thisProduct = prodServ.findProduct(id);
		model.addAttribute("product", thisProduct);
		
		
		List<Category> allCategories = cateServ.allCategories();
		model.addAttribute("categories", allCategories);
		return "/products/show.jsp";
	}
	@PostMapping("/products/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long id,
										@RequestParam("categoryId") Long categoryId){
		Category cat = cateServ.findCategory(categoryId);
		Product prod = prodServ.findProduct(id);
		
//		---- adding a product to a category ---
		prod.getCategories().add(cat);
		prodServ.updateProduct(prod);
//		--------
		
		return "redirect:/products/" + id;
	}

	
//--------SHOW ONE CATEGORY---------
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable ("id") Long id, Model model) {
		Category thisCategory = cateServ.findCategory(id);
		model.addAttribute("category", thisCategory);
		
		List<Product> allProducts = prodServ.allProducts();
		model.addAttribute("products", allProducts);
		return "/categories/show.jsp";
	}
	@PostMapping("categories/{id}")
	public String addProductToCategory(@PathVariable("id") Long id, 
										@RequestParam("productId") Long productId){
		Product prod = prodServ.findProduct(productId);
		Category cat = cateServ.findCategory(id);
		
		cat.getProducts().add(prod);
		cateServ.updateCategory(cat);
		
		return"redirect:/categories/" + id;
	}
	
	
	
	
	
	
//DELETE
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public String destroyProd(@PathVariable("id") Long id) {
        prodServ.deleteProduct(id);
        return "redirect:/";
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.DELETE)
    public String destroyCat(@PathVariable("id") Long id) {
        cateServ.deleteCategory(id);
        return "redirect:/";
	}

}
	
