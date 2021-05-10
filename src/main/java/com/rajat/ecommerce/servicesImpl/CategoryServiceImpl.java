package com.rajat.ecommerce.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajat.ecommerce.entities.Category;
import com.rajat.ecommerce.exceptions.CategoryExistsException;
import com.rajat.ecommerce.exceptions.CategoryNotFoundException;
import com.rajat.ecommerce.repos.CategoryRepository;
import com.rajat.ecommerce.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category c) {
        Category category = categoryRepository.findByName(c.getName());
        if(category != null)
            throw new CategoryExistsException("Category " + c.getName() + "already exists!");
        return categoryRepository.save(c);
    }

    @Override
    public Iterable<Category> deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return categoryRepository.findAll();
    }

    @Override
    public Category findByName(String name) {
        Category category = categoryRepository.findByName(name);

        if(category == null) throw new CategoryNotFoundException("Category not found");

        return category;
    }

    @Override
    public Category update(String name, Category newCategory) {
        Long id = categoryRepository.findByName(name).getId();

        if(id == null) throw new CategoryNotFoundException("Category not found");

        newCategory.setId(id);
        return categoryRepository.save(newCategory);
    }
}
