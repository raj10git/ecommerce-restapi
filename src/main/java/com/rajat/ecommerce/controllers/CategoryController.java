package com.rajat.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.ecommerce.exceptions.ConflictException;
import com.rajat.ecommerce.entities.Category;
import com.rajat.ecommerce.exceptions.CategoryExistsException;
import com.rajat.ecommerce.exceptions.CategoryNotFoundException;
import com.rajat.ecommerce.exceptions.NotFoundException;
import com.rajat.ecommerce.services.CategoryService;

@RestController
@RequestMapping("/Categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{categoryName}")
	public Category findCategoryByName(@PathVariable String categoryName){
		try {
            Category c = categoryService.findByName(categoryName);
            return c;
        }
        catch (CategoryNotFoundException e){
            throw new NotFoundException(e.getMessage());
        }
	}
	@PostMapping("/newCategory")
	public Category createCategory(@RequestBody Category newCategory) {
		try {
			Category createdCategory = categoryService.save(newCategory);
			return createdCategory;
		}
		catch(CategoryExistsException e){
			throw new ConflictException(e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public Iterable<Category> delete(@PathVariable Long categoryId){
		try {
			return categoryService.deleteCategory(categoryId);
		}
		catch(CategoryNotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}
	} 
}
