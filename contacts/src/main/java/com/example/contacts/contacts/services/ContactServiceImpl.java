package com.example.contacts.contacts.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contacts.contacts.model.Contact;
import com.example.contacts.contacts.repository.ContactRepository;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repository;
	
	@Autowired Contact contactEntity;
	
	public ContactServiceImpl(ContactRepository repo) {
		repository = repo;
	}
	
	public Contact saveContact(Contact contact) {
		return repository.save(contact);
	}
	
	public List<Contact> listContacts(){
		return repository.findAll();
	}
	
	public Contact searchById(Long id) {
		return repository.getOne(id);
	}
	
	public Contact updateContact(Long id, Contact contact) {
		contactEntity = repository.getOne(id);
		contactEntity = contact;
		repository.save(contactEntity);
		return contactEntity;
	}
	
	public void deleteContact(Long id) {
		contactEntity = repository.getOne(id);
		repository.delete(contactEntity);
	}
	
	
}
