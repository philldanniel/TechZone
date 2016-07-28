package com.ecomm.techzone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	private String sup_id;
	private String sup_name;
	private String sup_address;
	
	@Id
	public String getSup_id() {
		return sup_id;
	}
	public void setSup_id(String sup_id) {
		this.sup_id = sup_id;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	public String getSup_address() {
		return sup_address;
	}
	public void setSup_address(String sup_address) {
		this.sup_address = sup_address;
	}
	
	
}
