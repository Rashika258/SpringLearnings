package com.example.c2tc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.c2tc.repositories.ContactRepository;
import com.example.c2tc.models.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	//get all contacts
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}
	
	//get contact by id
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}
	
	//delete contact
	public void delete(int id) {
		contactRepository.deleteById(id);
	}
	
	//update contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	}
