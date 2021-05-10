package com.rajat.ecommerce.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rajat.ecommerce.entities.Product;
import com.rajat.ecommerce.entities.Seller;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
    public List<Product> findByName(String name);
    public List<Product> findAll();

    public List<Product> findProductByProducer(@Param("seller") Seller seller);
}
