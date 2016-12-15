package com.RestExample.services;

import java.util.List;

import com.RestExample.model.Friend;

public interface FriendService {
	
	List<Friend> getAllFriends();
	Friend getFriendById (int id);
	void saveFriend(Friend friend);
	Friend updateFriend(int id, Friend friend);
	void deletFriend(int id);

}
