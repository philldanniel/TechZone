package com.ecomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.UserDAO;
import com.ecomm.techzone.model.User;

public class UserTest {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		UserDAO userDAO =  (UserDAO) context.getBean("userDAO");
		
		
		User user = (User) context.getBean("user");
		user.setId("abc");
		user.setName("ABCXYZ");
		user.setPassword("123456");
		user.setMobile("8897989885");
		user.setMail_id("xyz@abc.com");
		user.setAddress("Andheri West,Mumbai");
		
		userDAO.saveOrUpdate(user);
		
//		userDAO.delete("S_03");
//		
//		System.out.println("" + userDAO.list().size());
		
	}

}
