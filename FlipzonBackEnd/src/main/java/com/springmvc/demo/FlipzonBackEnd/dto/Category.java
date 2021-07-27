package com.springmvc.demo.FlipzonBackEnd.dto;
//dto transfers  object from class to database
//groupid.artifactid.dto (for classes that will be used to transfer data to database table where dto stands for Data Transfer Object)

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {	
	//Annotate the class with the @Entity annotation the entity name will be same as the class unless you want to change it.
	//All the entity class needs to have an id so we are going to annotate it using @Id
	// Use the auto generation strategy of IDENTITY
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	//always a good idea to add the toString method for checking purpose and solving errors
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	/*
	 * Private fields
	 */
	private int id;
	private String name;
	private String description;
	
	//only path of image url
	//@Column(name = "image_url")
	private String imageURL;
	
	//@Column(name="is_active")
	private boolean active = true;
}
