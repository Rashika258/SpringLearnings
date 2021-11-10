package com.springmvc.demo.FlipzonBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springmvc.demo.FlipzonBackEnd.dao.CategoryDAO;
import com.springmvc.demo.FlipzonBackEnd.dto.Category;

public class CategoryTestCase {
	// Create a CategoryTestCase class
	
	// using the AnnotationConfigApplicationContext and CategoryDAO class
	//AnnotationConfigApplicationContext is a standalone application context which accepts annotated classes as input. For instance, @Configuration or @Component . Beans can be looked up with scan() or registered with register() .
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	private Category category;
	
	//The BeforeClass annotation indicates that the static method to which is attached must be executed once and before all tests in the class. That happens when the test methods share computationally expensive setup (e.g. connect to database).	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.springmvc.demo.FlipzonBackEnd");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category=new Category();
//		category.setName("Refrigerators");
//		category.setDescription("Descripton of refrigerator");
//		category.setImageURL("CAT_4.png");
//		category.setActive(false);
//		//If you want to test equality of two objects, you have the following methods
//		//assertEquals(expected, actual)
//		//It will return true if: expected.equals( actual ) returns true.
//		assertEquals("successfully added category inside table",true, categoryDAO.add(category));
//	}
	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
//		category.setName("Laptop");
//		category.setDescription("This is some description for laptop!");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//		
//		
//		category = new Category();
//		
//		category.setName("Television");
//		category.setDescription("This is some description for television!");
//		category.setImageURL("CAT_2.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		
				
		
	}
	
	
}
