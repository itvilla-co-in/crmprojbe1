package com.itvilla.project.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itvilla.project.dao.Userdao;
import com.itvilla.project.model.Page;
import com.itvilla.project.model.Page2;
import com.itvilla.project.model.User;
import com.itvilla.project.model.User2;
import com.itvilla.project.service.Pageservice;




//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class PageController {
	
	@Autowired
	Pageservice serv;
	@Autowired
	Userdao udao;
	
	//User myuser = new User();
	@Autowired
	User myuser;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping(value= "/page") public Collection<Page> getAll() {
		logger.debug("Getting all employees."); 
		return serv.getAllPages(); 
		}
	
	@PostMapping(value= "/page")
	public String create(@RequestBody List<Page> page) {
		logger.debug("Saving pages.");
		serv.createPage(page);
		return "Employee records created.";
	}

	@CrossOrigin
	@GetMapping(value= "/page/{slug}") 
	public Optional<Page> getPagebySlug(@PathVariable(value= "slug") String slug) {
		logger.debug("Getting all employees."); 
		return serv.findPagebySlug(slug); 
		}
	
	@CrossOrigin
	@GetMapping(value= "/pages/delete-page/{slug}") 
	public void deletePage(@PathVariable(value= "slug") String slug) {
		System.out.println("coming in delete with id "+ slug);
	    serv.deletebySlug(slug); 
	}
	
	@CrossOrigin
	@PostMapping(value= "/users/register")
	@ResponseBody
	public String userRegister(@RequestBody User2 user) {
		logger.debug("in register" + user.toString()); 
		System.out.println("is it coming here " + user.getUsername() + user.getPassword());
		myuser.setPassword(user.getPassword());
		myuser.setUsername(user.getUsername());
		User tempuser = udao.findByUsername(user.getUsername());
		 
				if (tempuser != null)
				{
					System.out.println("username exists");
					tempuser = null;
					return "{" + "\"" + "usernameexist" + "\"" + ":" + " true" + "}"; 
					 
				}else {
				tempuser = null;
				serv.createUser(myuser);
				}
				return "{" + "\"" + "usernameexist" + "\"" + ":" + " false" + "}"; 

		}
	
	@CrossOrigin
	@PostMapping(value= "/users/login")
	@ResponseBody
	public String userLogin(@RequestBody User2 user) {
		logger.debug("in login" + user.toString()); 
		System.out.println("is it coming here " + user.getUsername() + user.getPassword());
		//myuser.setPassword(user.getPassword());
		//myuser.setUsername(user.getUsername());
		User tempuser = udao.findByUsername(user.getUsername());
		 
				if (tempuser != null)
				{
					System.out.println("username exists and login success");
					//return "{" + "\"" + "invalidLogin" + "\"" + ":" + " false" + "}"; 
					// Creating Object of ObjectMapper define in Jakson Api 
			        ObjectMapper Obj = new ObjectMapper(); 
 			        try { 
			            String jsonStr = Obj.writeValueAsString(tempuser.getUsername()); 
			            System.out.println(jsonStr); 
			            return jsonStr;
			        } 
 			        catch (IOException e) { 
			            e.printStackTrace(); 
			        } 
					
				} else {
				tempuser = null;
				//serv.createUser(myuser);
				}
				return "{" + "\"" + "invalidLogin" + "\"" + ":" + " true" + "}"; 

		}
	@CrossOrigin
	@PostMapping(value= "/pages/add-page")
	@ResponseBody
	public String addPage(@RequestBody Page2 page2) {
		logger.debug("in add page" + page2.getTitle() + page2.getContent() + page2.getHasSidebar()); 
		System.out.println("is it coming in add page **** " + page2.getTitle() + page2.getContent() + page2.getHasSidebar());
		Page mypage = new Page();
		Optional<Page> temppage = serv.findPagebySlug(page2.getTitle().toLowerCase());
		 
				if (temppage.isPresent())
				{
					System.out.println("page exists" + temppage.toString());
					temppage = null;
					return "{" + "\"" + "pageExist" + "\"" + ":" + " true" + "}"; 
					 
				}else {
					temppage = null;
					mypage.setTitle(page2.getTitle());
					mypage.setSlug(page2.getTitle().toLowerCase());
					mypage.setContent(page2.getContent());
					mypage.setSidebar((page2.getHasSidebar() == "true") ? "true" : "false");
				serv.createPage(mypage);
				}
				return "{" + "\"" + "pageExist" + "\"" + ":" + " false" + "}"; 
		 
		}
	 
}
