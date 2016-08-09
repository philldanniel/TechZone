package com.ecomm;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.ProductDAO;
import com.ecomm.techzone.model.Product;

public class ProductTestCase {


	static AnnotationConfigApplicationContext context;
	
	@Autowired 
	static ProductDAO productDAO;
	
	@Autowired 
	static Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}
	
	@Test
	public void productTest(){
		int size = productDAO.list().size();
		assertEquals("User list test case", 4, size);
	}

}
