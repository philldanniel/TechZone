/*package com.ecomm;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.UserDAO;
import com.ecomm.techzone.model.User;

public class UserTestCase {


	static AnnotationConfigApplicationContext context;
	
	@Autowired 
	static UserDAO userDAO;
	
	@Autowired 
	static User user;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}
	
	@Test
	public void userTest(){
		int size = userDAO.list().size();
		assertEquals("User list test case", 3, size);
	}

}
*/