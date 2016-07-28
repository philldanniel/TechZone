package com.ecomm.techzone.dao;

import java.util.List;

import com.ecomm.techzone.model.Category;

public interface CategoryDAO {
	
	
	public List<Category> list();
	public Category get(String cat_id);
	public void saveOrUpdate(Category category);
	public void delete(String cat_id);
}
