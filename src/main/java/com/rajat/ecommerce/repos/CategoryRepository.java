package com.rajat.ecommerce.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajat.ecommerce.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	public void deleteById(Long id);
	public Category findByName(String name);
}
