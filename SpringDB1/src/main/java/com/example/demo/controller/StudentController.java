package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.repo.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo sr;
	
	public List<Student> getStudents() {
		return this.sr.get
	}
	
	@PostMapping("/students/{uid}")
	public StudentRepo addStudent(@RequestBody Student s1) {
		return  this.sr;
	}
}
