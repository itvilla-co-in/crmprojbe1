package com.itvilla.project.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvilla.project.dao.Pagedao;
import com.itvilla.project.dao.Userdao;
import com.itvilla.project.model.Page;
import com.itvilla.project.model.User;
@Service
public class PageserviceImpl implements Pageservice {
	
	// The dao repository will use the Mongodb-Repository to perform the database operations.
		@Autowired
		Pagedao dao;
		
		@Autowired
		Userdao udao;
		
	@Override
	public  Collection<Page> getAllPages(){
		return dao.findAll();
	}
	
	@Override
	public void createPage(List<Page> page) {
		dao.saveAll(page);
	}

	@Override
	public Optional<Page> findPagebySlug(String slug) {
		// TODO Auto-generated method stub
		return dao.findBySlug(slug);
	}
	@Override
	public void deletebySlug(String slug) {
		 dao.deleteBySlug(slug);
	}

	
	@Override
	public Optional<Page> findPagebyId(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void createUser(User user) {
		udao.save(user);
		
	}

	@Override
	public void createPage(Page page) {
		dao.save(page);
		
	}

	@Override
	public void deletePage(String id) {
		dao.deleteById(id);
	

	}

}
