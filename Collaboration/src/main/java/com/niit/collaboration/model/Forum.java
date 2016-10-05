package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="FORUM")
@Component
public class Forum {

	@Id
	@Column(name="forumid")
	private int forumid;
	
	@Column(name="mailid")
	private String mailid;
	
	@Column(name="description")
	private String description;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="date_of_creation")
	private Date date_of_creation;
	
	@Column(name="date_of_modification")
	private Date date_of_modification;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDate_of_creation() {
		return date_of_creation;
	}

	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public Date getDate_of_modification() {
		return date_of_modification;
	}

	public void setDate_of_modification(Date date_of_modification) {
		this.date_of_modification = date_of_modification;
	}


}
