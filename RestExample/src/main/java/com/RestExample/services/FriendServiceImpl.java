package com.RestExample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestExample.dao.FriendDao;
import com.RestExample.model.Friend;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public FriendDao getFriendDao() {
		return friendDao;
	}
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	
	
	public List<Friend> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	
	public Friend getFriendById(int id) {
		// TODO Auto-generated method stub
		return getFriendById(id);
	}


	public void saveFriend(Friend friend) {
		// TODO Auto-generated method stub
		friendDao.saveFriend(friend);
	}


	public Friend updateFriend(int id, Friend friend) {
		// TODO Auto-generated method stub
		return friendDao.updateFriend(id, friend);
	}

	
	public void deletFriend(int id) {
		// TODO Auto-generated method stub
	friendDao.deletFriend(id);	
	}

}
