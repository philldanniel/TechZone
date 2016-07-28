package com.ecomm.techzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category {
	private String cat_id;
	private String cat_name;
	private String cat_details;
	private String subcat_id;
	
	@Id
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getCat_details() {
		return cat_details;
	}
	public void setCat_details(String cat_details) {
		this.cat_details = cat_details;
	}
	public String getSubcat_id() {
		return subcat_id;
	}
	public void setSubcat_id(String subcat_id) {
		this.subcat_id = subcat_id;
	}
	
	
	

}
