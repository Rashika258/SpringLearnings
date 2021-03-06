package com.spring.mvc.SpringDemo;
import org.springframework.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mvc.demo.Bike;
import com.spring.mvc.demo.Car;
import com.spring.mvc.demo.Tyre;
import com.spring.mvc.demo.Vehicle;

public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        Car car=new Car();
//        car.drive();
//        Bike bike=new Bike();
//        bike.drive();
//        Vehicle obj=new Car();
//        obj.drive();
    	
        ApplicationContext context=new ClassPathXmlApplicationContext("/SpringDemo/src/main/java/com/spring/mvc/demo/spring.xml");
//        Vehicle obj1=(Vehicle)context.getBean("car");
//        obj1.drive();
//        ApplicationContext context=new ClassPath
//        Tyre t=(Tyre)context.getBean("tyre");
        
        Car obj=(Car)context.getBean("car");
        obj.drive();
    
    }
}
