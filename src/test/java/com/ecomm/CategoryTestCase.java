/*package com.ecomm;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.CategoryDAO;
import com.ecomm.techzone.model.Category;

public class CategoryTestCase {


	static AnnotationConfigApplicationContext context;
	
	@Autowired 
	static CategoryDAO categoryDAO;
	
	@Autowired 
	static Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}
	
	@Test
	public void categoryTest(){
		int size = categoryDAO.list().size();
		assertEquals("User list test case", 5, size);
	}

}
*/