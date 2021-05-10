package com.rajat.ecommerce.services;

import com.rajat.ecommerce.entities.Category;

public interface CategoryService {
    public Category save(Category c);
    public Iterable<Category> deleteCategory(Long categoryId);
    public Category findByName(String name);
    public Category update(String name, Category newCategory);
}
