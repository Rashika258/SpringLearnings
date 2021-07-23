package com.springmvc.flipzonfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
//	We will be creating a controller class that will handle various url mapping like /, /index, /home all will be
//	mapped to the same method handler. It will generate the data (greeting in our case) and along with it
//	the logical view name
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");

		return mv;				
	}
	

}
