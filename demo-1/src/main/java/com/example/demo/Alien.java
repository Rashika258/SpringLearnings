package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")
public class Alien {
	int aid;
	String aname;
	String atech;
	@Autowired
//	@Qualifier("laptop")
	@Qualifier("lap1")
	private Laptop laptop;
	
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Constructor created");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtech() {
		return atech;
	}
	public void setAtech(String atech) {
		this.atech = atech;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void show() {
		System.out.println("Inside show");
		laptop.compile();
	}
}
