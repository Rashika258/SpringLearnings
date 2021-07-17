package com.example.repo;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentRepo {
	public Student addStudents(Student s1);
	public List<Student> getStudents();
}
