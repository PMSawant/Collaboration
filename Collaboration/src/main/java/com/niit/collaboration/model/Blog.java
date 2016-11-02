package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity

@Component
public class Blog {
	
	@Id
	@Column(name="blogid")
	private int blogid;
	
	@Column(name="mailid")
	private String mailid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private boolean status;

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getmailid() {
		return mailid;
	}

	public void setmailid(String mailid) {
		this.mailid = mailid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



}
