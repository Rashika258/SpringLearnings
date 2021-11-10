package com.springmvc.flipzonfrontend.model;

import java.io.Serializable;

import com.springmvc.demo.FlipzonBackEnd.dto.Address;
import com.springmvc.demo.FlipzonBackEnd.dto.User;

public class RegisterModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Create a RegisterModel class which will hold both the user and billing address.
	private User user;
	private Address billing;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}
		
}
