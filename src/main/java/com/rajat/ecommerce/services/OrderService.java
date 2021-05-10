package com.rajat.ecommerce.services;

import java.util.List;

import com.rajat.ecommerce.entities.Orders;

public interface OrderService {
	public List<Orders> findAll();
    public Orders save(Orders o);
    public List<Orders> findOrdersByClient(Long id);
}
