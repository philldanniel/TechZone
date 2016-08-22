package com.ecomm.techzone.dao;

import java.util.List;

import com.ecomm.techzone.model.CheckoutDetails;


public interface CheckoutDetailsDAO {
	
	
	public List<CheckoutDetails> list();
	public CheckoutDetails get(String id);
	public void saveOrUpdate(CheckoutDetails checkoutDetails);
	public void delete(String id);

}
