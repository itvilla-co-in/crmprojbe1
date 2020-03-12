package com.itvilla.project.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.

public class Page2 {


	private String title;
	private String content;
	private String hasSidebar;

	public Page2() {	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getHasSidebar() {
		return hasSidebar;
	}

	public void setHasSidebar(String hasSidebar) {
		this.hasSidebar = hasSidebar;
	}

	@Override
	public String toString() {
		return "Page2 [title=" + title + ", content=" + content + ", sidebar=" + hasSidebar + "]";
	}

	

	
}