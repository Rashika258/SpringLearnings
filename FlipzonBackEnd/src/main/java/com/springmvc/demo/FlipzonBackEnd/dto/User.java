package com.springmvc.demo.FlipzonBackEnd.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

//Serializable is a marker interface your classes must implement if they are to be serialized and deserialized. Java object serialization (writing) is done with the ObjectOutputStream and deserialization (reading) is done with the ObjectInputStream.That Serializable is a marker interface means that it contains no methods. Therefore, a class implementing Serializable does not have to implement any specific methods. Implementing Serializable thus just tells the Java serialization classes that this class is intended for object serialization.

@Entity
public class User implements Serializable {
	
	// serialVersionUID variable is used by Java's object serialization API to determine if a deserialized object was serialized (written) with the same version of the class, as it is now attempting to deserialize it into.

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Please enter first name!")
	private String firstName;
	
	@NotBlank(message = "Please enter last name!")
	private String lastName;
	
	@NotBlank(message = "Please enter email address!")	
	private String email;
	
	@NotBlank(message = "Please enter contact number!")
	private String contactNumber;
	
	private String role;
	
	@NotBlank(message = "Please enter password!")
	private String password;
	
	private boolean enabled = true;
	
	@Transient
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}
	
	
	@OneToOne(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
