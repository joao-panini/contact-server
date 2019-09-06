package com.example.contacts.contacts.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Component
@Table(name = "Contacts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	private String address;
	
	private String email;
	
	private String cellphone_number;

	public Contact() {
		
	}
	
	public Contact(@NotBlank String name, String address, String email, String cellphone_number) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.cellphone_number = cellphone_number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone_number() {
		return cellphone_number;
	}

	public void setCellphone_number(String cellphone_number) {
		this.cellphone_number = cellphone_number;
	}
}
