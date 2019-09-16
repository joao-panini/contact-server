package com.example.contacts.client.contactclient.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String email;
	
	private String cellphone_number;
	
	public Contact() {
		
	}
	public Contact(String name, String address, String email, String cellphone_number) {
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

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", cellphone_number=" + cellphone_number + "]";
	}
	
	
}
