package com.rajat.ecommerce.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajat.ecommerce.entities.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long>{
	public List<Orders> findAll();
    //public Orders findOne(Long aLong);
}