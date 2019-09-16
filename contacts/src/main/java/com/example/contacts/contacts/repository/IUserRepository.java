package com.example.contacts.contacts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.contacts.contacts.model.User;

@Service
public interface IUserRepository extends CrudRepository<User, Integer>{

}
