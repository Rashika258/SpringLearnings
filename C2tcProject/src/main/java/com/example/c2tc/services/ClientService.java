package com.example.c2tc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.c2tc.models.Client;
import com.example.c2tc.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	//get all clients
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	//get client by id
	public  Optional<Client> findById(int id){
		return clientRepository.findById(id);
	}
	
	//delete client
	public void delete(int id) {
		clientRepository.deleteById(id);
	}
	
	//update client
	public void save(Client client) {
		clientRepository.save(client);
	}
}
