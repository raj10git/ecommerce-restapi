package com.rajat.ecommerce.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajat.ecommerce.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	
	  public Client findByUsername(String username);
	    public List<Client> findAll();
	    public void deleteById(Long id);
	    public Client findOne(Long id);
}
