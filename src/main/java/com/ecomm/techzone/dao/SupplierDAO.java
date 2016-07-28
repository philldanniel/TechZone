package com.ecomm.techzone.dao;

import java.util.List;

import com.ecomm.techzone.model.Supplier;

public interface SupplierDAO {
	
	
	public List<Supplier> list();
	public Supplier get(String sup_id);
	public void saveOrUpdate(Supplier supplier);
	public void delete(String sup_id);

}
