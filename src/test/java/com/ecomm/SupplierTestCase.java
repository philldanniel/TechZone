package com.ecomm;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.SupplierDAO;
import com.ecomm.techzone.model.Supplier;

public class SupplierTestCase {


	static AnnotationConfigApplicationContext context;
	
	@Autowired 
	static SupplierDAO supplierDAO;
	
	@Autowired 
	static Supplier supplier;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
	}
	
	@Test
	public void supplierTest(){
		int size = supplierDAO.list().size();
		assertEquals("User list test case", 4, size);
	}

}
