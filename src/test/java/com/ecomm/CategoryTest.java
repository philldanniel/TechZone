package com.ecomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.CategoryDAO;
import com.ecomm.techzone.model.Category;

public class CategoryTest {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		CategoryDAO categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		category.setCat_id("C_01");
		category.setCat_name("Mobile");
		category.setCat_details("Smartphone");
		category.setSubcat_id("sc_01");
		
		
		categoryDAO.saveOrUpdate(category);
	}

}
