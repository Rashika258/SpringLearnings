package com.springmvc.flipzonfrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springmvc.demo.FlipzonBackEnd.dao.UserDAO;
import com.springmvc.demo.FlipzonBackEnd.dto.Address;
import com.springmvc.demo.FlipzonBackEnd.dto.Cart;
import com.springmvc.demo.FlipzonBackEnd.dto.User;
import com.springmvc.flipzonfrontend.model.RegisterModel;

@Component
public class RegisterHandler {

	//Create a RegisterHandler class to provide the above model at the start of the flow along with both the flow instance variable.

 @Autowired
 private PasswordEncoder passwordEncoder;
	
	
 @Autowired
 private UserDAO userDAO;
 
 public RegisterModel init() { 
  return new RegisterModel();
 } 
 public void addUser(RegisterModel registerModel, User user) {
  registerModel.setUser(user);
 } 
 public void addBilling(RegisterModel registerModel, Address billing) {
  registerModel.setBilling(billing);
 }

 public String validateUser(User user, MessageContext error) {
  String transitionValue = "success";
   if(!user.getPassword().equals(user.getConfirmPassword())) {
    error.addMessage(new MessageBuilder().error().source(
      "confirmPassword").defaultText("Password does not match confirm password!").build());
    transitionValue = "failure";    
   }  
   if(userDAO.getByEmail(user.getEmail())!=null) {
    error.addMessage(new MessageBuilder().error().source(
      "email").defaultText("Email address is already taken!").build());
    transitionValue = "failure";
   }
  return transitionValue;
 }
 
 public String saveAll(RegisterModel registerModel) {
  String transitionValue = "success";
  User user = registerModel.getUser();
  if(user.getRole().equals("USER")) {
   // create a new cart
   Cart cart = new Cart();
   cart.setUser(user);
   user.setCart(cart);
  }
   
  //Autowired the bean inside the RegisterHandler that we created for registering a user and call the encode method on user entered password.
  
  // encode the password
  user.setPassword(passwordEncoder.encode(user.getPassword()));
  
  // save the user
  userDAO.add(user);
  // save the billing address
  Address billing = registerModel.getBilling();
  billing.setUserId(user.getId());
  billing.setBilling(true);  
  userDAO.addAddress(billing);
  return transitionValue ;
 } 
}

