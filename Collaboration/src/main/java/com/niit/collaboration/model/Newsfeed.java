package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="NEWSFEED")
@Component
public class Newsfeed {

	public int getNewsfeedid() {
		return newsfeedid;
	}

	public void setNewsfeedid(int newsfeedid) {
		this.newsfeedid = newsfeedid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@Column(name="newsfeedid")
	private int newsfeedid;
	
	@Column(name="description")
	private String description;
	
	

}
