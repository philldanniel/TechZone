package com.ecomm.techzone.dao;

import java.util.List;

import com.ecomm.techzone.model.Cart;

public interface CartDAO {
	
	
	public List<Cart> list(String id);
	public Cart get(String id);
	public void save(Cart cart);
	public void saveOrUpdate(Cart cart);
	public void delete(int id);
	public Long getTotalAmount(String id);

}
