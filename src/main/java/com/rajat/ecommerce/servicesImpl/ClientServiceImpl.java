package com.rajat.ecommerce.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rajat.ecommerce.exceptions.ClientExistsException;
import com.rajat.ecommerce.entities.Client;
import com.rajat.ecommerce.exceptions.CLientNotFoundException;
import com.rajat.ecommerce.repos.ClientRepository;
import com.rajat.ecommerce.services.ClientService;

public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public Client findByUsername(String username) {
		Client c  = clientRepo.findByUsername(username);
		if(c == null) {
			throw new CLientNotFoundException("Client not found");
		}
		return c;
	}

	@Override
	public Iterable<Client> deleteClient(Long id) {
		Client c = clientRepo.findById(id).orElse(null);
		
		if(c == null) {
			throw new CLientNotFoundException("Client not found");
		}
		return clientRepo.findAll();
	}

	@Override
	public Client save(Client c) {
		if(clientRepo.findByUsername(c.getUsername()) != null)
            throw new ClientExistsException("Client with \'" + c.getUsername() + " \' username exists");

        return clientRepo.save(c);
	}
}
