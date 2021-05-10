package com.rajat.ecommerce.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rajat.ecommerce.entities.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long>{
	
    public Seller findByName(@Param("name") String name);
}
