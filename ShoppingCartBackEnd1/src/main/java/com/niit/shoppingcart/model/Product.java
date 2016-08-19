package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "PRODUCT")
@Component
public class Product {

	private String id;
	private String name;
	private String price;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getprice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
