package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@Component
public class User {

	private String id;
	private String name;
	private String desc;
	private String mobileno;
	private String email;
	private String password;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "admin", columnDefinition = "tinyint default 1")
	private byte admin;

	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Column(name="mobileno")
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setadmin(byte admin) {
		this.admin=admin;
		
	}

	public byte getAdmin() {
		// TODO Auto-generated method stub
		return admin;
	}


}
