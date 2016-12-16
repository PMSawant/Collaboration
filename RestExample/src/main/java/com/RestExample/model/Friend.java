package com.RestExample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friend")
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int friendId;
	private String friendName;
	private String friendMail;
	private boolean request;
	
	
	public boolean isRequest() {
		return request;
	}
	public void setRequest(boolean request) {
		this.request = request;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendMail() {
		return friendMail;
	}
	public void setFriendMail(String friendMail) {
		this.friendMail = friendMail;
	}

}
