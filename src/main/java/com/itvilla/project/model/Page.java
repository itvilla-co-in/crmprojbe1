package com.itvilla.project.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Mongo database annotation.
@Document(collection= "pages")
public class Page {

	@Id
	private ObjectId  Id;
	private String title;
	private String slug;
	private String content;
	private String sidebar;

	public Page() {	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSidebar() {
		return sidebar;
	}

	public void setSidebar(String sidebar) {
		this.sidebar = sidebar;
	}
	
	

	public ObjectId getId() {
		return Id;
	}

	public void setId(ObjectId id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "Page [title=" + title + ", slug=" + slug + ", content=" + content + ", sidebar=" + sidebar + "]";
	}

	
}