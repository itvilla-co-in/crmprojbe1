package com.itvilla.project.dao;


import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itvilla.project.model.Page;
import com.itvilla.project.model.User;

public interface Pagedao extends MongoRepository<Page, String> {

	public Optional<Page> findBySlug(String slug);

	public void deleteById(ObjectId Id);
	
	public void deleteBySlug(String slug);
	
	public Optional<Page> findById(String id);
	
}