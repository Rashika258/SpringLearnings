package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Course {
	int cid;
	String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Course(){
		System.out.println("Course object created");
	}
	void show() {
		System.out.println("In course");
	}
}
