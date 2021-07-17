package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo1Application {
//spring uses singleton design pattern by default object  will be created
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Demo1Application.class, args);
		Alien a=context.getBean(Alien.class);
		a.show();
		//even if object is created twice only once it will called by spring framework 
//		Alien a1=context.getBean(Alien.class);
//		a1.show();
		System.out.println("welcome to boot");
	
	
	}

}
