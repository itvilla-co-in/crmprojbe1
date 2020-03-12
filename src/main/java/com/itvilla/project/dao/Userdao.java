package com.itvilla.project.dao;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itvilla.project.model.Page;
import com.itvilla.project.model.User;

public interface Userdao extends MongoRepository<User, Integer> {

	User findByUsername(String username);
	
}