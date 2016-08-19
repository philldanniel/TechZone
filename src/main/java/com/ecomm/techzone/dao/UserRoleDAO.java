package com.ecomm.techzone.dao;

import java.util.List;

import com.ecomm.techzone.model.UserRole;

public interface UserRoleDAO {
	
	
	public List<UserRole> list();
	public UserRole get(String id);
	public void saveOrUpdate(UserRole userRole);
	public void delete(String id);

}
