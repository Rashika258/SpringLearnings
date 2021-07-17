package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.Student;

@Controller
public class StudentController {
	@RequestMapping("/")
	public String home() {
		return "details.jsp";
	}
	@RequestMapping("/addStudent")
	public void addStudent(Student s1) {
		ModelAndView mv=new ModelAndView("details.jsp");
		mv.addObject(s1);
	}
}
