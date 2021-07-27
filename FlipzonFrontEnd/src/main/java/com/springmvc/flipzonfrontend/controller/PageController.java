package com.springmvc.flipzonfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.FlipzonBackEnd.dao.CategoryDAO;
import com.springmvc.demo.FlipzonBackEnd.dto.Category;

@Controller
public class PageController {
//	We will be creating a controller class that will handle various url mapping like /, /index, /home all will be
//	mapped to the same method handler. It will generate the data (greeting in our case) and along with it
//	the logical view name
	
	//dependency injection feature of Spring framework and Autowired the class which implements DAO interface
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClicksHome",true);
		return mv;				
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","About");
		mv.addObject("userClicksAbout",true);
		return mv;				
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Contact");
		mv.addObject("userClicksContact",true);
		return mv;				
	}
	
	/*
	 * Method to load all products and also based on category
	 */
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClicksAllProducts",true);
		return mv;				
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClicksCategoryProducts",true);
		return mv;				
	}	
	
}
