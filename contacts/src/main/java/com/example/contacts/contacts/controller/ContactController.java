package com.example.contacts.contacts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contacts.contacts.model.Contact;
import com.example.contacts.contacts.services.ContactServiceImpl;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	
	@Autowired
	private ContactServiceImpl contactService;
	
	@Autowired
	private Contact contactEntity;
	
	@PostMapping("/addContact")
	public Contact addContact(@Valid @RequestBody Contact contact) {
		contactEntity.setAddress(contact.getAddress());
		contactEntity.setCellphone_number(contact.getCellphone_number());
		contactEntity.setEmail(contact.getEmail());
		contactEntity.setName(contact.getName());
		return contactService.saveContact(contactEntity);
	}
	
	@GetMapping("/all")
	public List<Contact> listContacts(){
		return contactService.listContacts();
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Contact> searchById(@PathVariable Long id){
		contactEntity = contactService.searchById(id);
		
		if(contactEntity == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contactEntity);
	}
	
	@PutMapping("/updateContact/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long id, 
			@Valid @RequestBody Contact contact){
		
		contactEntity = contactService.searchById(id);
		if(contactEntity == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(contact, contactEntity, "id");
		contactService.saveContact(contactEntity);
		return ResponseEntity.ok(contactEntity);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<Void> removeContact(@PathVariable Long id){
		contactEntity = contactService.searchById(id);
		if(contactEntity == null) {
			return ResponseEntity.notFound().build();
		}
		contactService.deleteContact(id);
		return ResponseEntity.noContent().build();
	}
	
}
