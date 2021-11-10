package com.example.c2tc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
	
	@GetMapping("/")
	public String goHome() {
		return "index";
	}

	@GetMapping("/index")
	public String goHomeIndex() {
		return "index";
	}
}
