package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="FRIEND")
@Component 
public class Friend {

	@Id
	@Column(name="friendid")
	private int friendid;
	
	@Column(name="mailid")
	private String mailid;
	
	@Column(name="totalfriends")
	private int totalfriends;
	
	@Column(name="request")
	private boolean request;

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public int getTotalfriends() {
		return totalfriends;
	}

	public void setTotalfriends(int totalfriends) {
		this.totalfriends = totalfriends;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}
	
 	
	
}
