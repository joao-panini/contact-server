package com.example.contacts.client.contactclient.client;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.contacts.client.contactclient.model.Contact;

@Component
public class CallRestService implements CommandLineRunner {
	
	private static void listContacts() {
		RestTemplate rt = new RestTemplate();
		Contact contact = rt.getForObject("http://localhost:8090/contacts/2", Contact.class);
		System.out.println("contact:" + contact.getName());
	}
	
	private static void addContact(String name, String address, String email, String cellphone_number) {
		RestTemplate rt = new RestTemplate();
		Contact contact = new Contact(name,address,email,cellphone_number);
		HttpEntity<Contact> request = new HttpEntity<>(new Contact(name,address,email,cellphone_number));
		
		ResponseEntity<Contact> response = rt
				  .exchange("http://localhost:8090/contacts/addContact", HttpMethod.POST, request, Contact.class);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		System.out.println("---MENU---");
		System.out.println("1 - listar contatos");
		System.out.println("2 - adicionar contato");
		System.out.println("3 - deletar contato");
		int opcao = teclado.nextInt();
		switch(opcao) {
			case 1:
				listContacts();
				break;
			case 2:
				addContact("test", "test", "test", "test");
				break;
		}

	}

	
}
