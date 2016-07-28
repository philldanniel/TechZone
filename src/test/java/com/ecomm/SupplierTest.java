package com.ecomm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.techzone.dao.SupplierDAO;
import com.ecomm.techzone.model.Supplier;

public class SupplierTest {
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ecomm.techzone");
		context.refresh();
		
		SupplierDAO supplierDAO =  (SupplierDAO) context.getBean("supplierDAO");
		
		
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setSup_id("S_03");
		supplier.setSup_name("Reliance");
		supplier.setSup_address("Mumbai");
		supplierDAO.saveOrUpdate(supplier);
		
		supplierDAO.delete("S_01");
		
		System.out.println("" + supplierDAO.list().size());
		
	}

}
