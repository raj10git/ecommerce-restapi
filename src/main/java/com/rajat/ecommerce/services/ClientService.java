package com.rajat.ecommerce.services;

import com.rajat.ecommerce.entities.Client;

public interface ClientService {
	public Client findByUsername(String username);
    public Iterable<Client> deleteClient(Long id);
    public Client save(Client c);
}
