package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {
	
	public void saveorUpdate(Friend friend);
	
	public void delete (int friendid);
	
	public Friend get(int friendid);

	public List<Friend> list();


}
