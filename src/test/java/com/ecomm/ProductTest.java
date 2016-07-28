package com.ecomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.ProductDAO;
import com.ecomm.techzone.model.Product;

public class ProductTest {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		ProductDAO productDAO =  (ProductDAO) context.getBean("productDAO");
		
		
		Product product = (Product) context.getBean("product");
		product.setId("P104");
		product.setName("MEIZU MX6 Pro");
		product.setCategory_name("Mobiles");
		product.setDescription("Android Smartphone");
		product.setPrice(25999);
		productDAO.saveOrUpdate(product);
		
//		productDAO.delete("S_01");
//		
//		System.out.println("" + productDAO.list().size());
		
	}

}
