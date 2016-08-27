package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USER")
@Component
public class User {

	@Id
	@GeneratedValue
	private String id;
	@NotNull
	@Size(min=3, max=10)
	private String name;
	@NotNull
	@Size(min=5, max=20)
	private String desc;
	@NotNull
	@Size(min=0, max=10)
	private String mobileno;
	@Email(message="Please enter valid email")
	@Pattern(regexp=".+@.+\\..+", message="Please enter valid email")
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

	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "mobileno")
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setadmin(byte admin) {
		this.admin = admin;

	}

	public byte getAdmin() {	
		return admin;
	}

}
