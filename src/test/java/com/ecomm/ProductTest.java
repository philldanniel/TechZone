package com.ecomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.CategoryDAO;
import com.ecomm.techzone.dao.ProductDAO;
import com.ecomm.techzone.model.Category;
import com.ecomm.techzone.model.Product;

public class ProductTest {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		ProductDAO productDAO =  (ProductDAO) context.getBean("productDAO");
		CategoryDAO categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
		Category category = (Category) context.getBean("category");
	
		Product product = (Product) context.getBean("product");
		product.setId("P108");
		product.setName("MEIZU M3");
		product.setDescription("Android Smartphone");
		product.setPrice(11999);
		productDAO.saveOrUpdate(product);
		
//		productDAO.delete("S_01");
//		
//		System.out.println("" + productDAO.list().size());
		
	}

}
