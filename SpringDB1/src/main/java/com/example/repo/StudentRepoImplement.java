package com.example.repo;

import java.util.List;
import java.util.ArrayList;
import com.example.demo.model.Student;

public class StudentRepoImplement implements StudentRepo {
	
	List<Student> li;
	Student s1=new Student(12, "rashika");
	

	public StudentRepoImplement() {
		li=new ArrayList<>();
		li.add(s1);
		li.add(new Student(13, "rashmika"));
	}

	@Override
	public Student addStudents(Student s1) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
