package com.RestExample.dao;

import java.util.List;

import com.RestExample.model.Friend;

public interface FriendDao {

	
	List<Friend> getAllFriends();
	Friend getFriendById (int id);
	void saveFriend(Friend friend);
	Friend updateFriend(int id, Friend friend);
	void deletFriend(int id);
}
