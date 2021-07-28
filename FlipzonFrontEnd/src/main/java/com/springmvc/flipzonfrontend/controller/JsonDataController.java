package com.springmvc.flipzonfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.demo.FlipzonBackEnd.dao.ProductDAO;
import com.springmvc.demo.FlipzonBackEnd.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	// Create a JsonDataController whose job will be to provide data in JSON format. At the class level we are going to add a RequestMapping of /json/data and for method we will add like all/products and category/{id}/products so the entire url will be

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		return productDAO.listActiveProductsByCategory(id);
	}
}
