package com.itvilla.project.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.itvilla.project.model.Page;
import com.itvilla.project.model.User;


public interface Pageservice {
	
	public Collection<Page> getAllPages();

	public void createPage(List<Page> page);
	
	public void createPage(Page page);


	public Optional<Page> findPagebySlug(String slug);
	
	public Optional<Page> findPagebyId(String id);

	public void deletebySlug(String slug);

	
	public void createUser(User user);

	public void deletePage(String id);

}
