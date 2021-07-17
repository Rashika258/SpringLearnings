package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home1Controller {
	@RequestMapping("home")
	//@ResponseBody - prints home.jsp
	public ModelAndView home(Alien alien) {
		
		ModelAndView mv=new ModelAndView();
		//System.out.println("Hii  "+name);
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
}
}
