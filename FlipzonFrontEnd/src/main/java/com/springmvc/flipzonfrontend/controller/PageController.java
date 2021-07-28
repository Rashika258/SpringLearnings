package com.springmvc.flipzonfrontend.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.FlipzonBackEnd.dao.CategoryDAO;
import com.springmvc.demo.FlipzonBackEnd.dao.ProductDAO;
import com.springmvc.demo.FlipzonBackEnd.dto.Category;
import com.springmvc.demo.FlipzonBackEnd.dto.Product;
import com.springmvc.flipzonfrontend.exception.ProductNotFoundException;



@Controller
public class PageController {
	
	//Using logger to test
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
//	We will be creating a controller class that will handle various url mapping like /, /index, /home all will be
//	mapped to the same method handler. It will generate the data (greeting in our case) and along with it
//	the logical view name
	
	//dependency injection feature of Spring framework and Autowired the class which implements DAO interface
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
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
	
	/*
	 * Viewing a single product
	 */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product=productDAO.get(id);
		
		//throwing exception
		if(product == null) throw new ProductNotFoundException();
				
		//update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//--------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClicksShowProduct", true);
		
		return mv;
	}
	
}
