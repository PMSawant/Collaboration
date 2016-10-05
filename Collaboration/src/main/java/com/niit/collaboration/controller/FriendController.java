package com.niit.collaboration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@RestController
public class FriendController {
	
	private static final Logger Logger =
			LoggerFactory.getLogger(FriendController.class);
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private Friend friend;
	
	@GetMapping("/friends")
	public ResponseEntity<List<Friend>> getFriend(){
	Logger.debug("Calling method getFriend");
	List<Friend> list=  friendDAO.list();		
	if(list.isEmpty())
		{
			return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<List<Friend>>(HttpStatus.OK); 
	}
	
	@GetMapping("/friend/{friendid}")
	public ResponseEntity<Friend> getFriend(@PathVariable("friendid") int friendid) {
		Logger.debug("Calling method getForum with friendid" + friendid);
		friend = friendDAO.get(friendid);
		if (friend == null)
		{
		return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<Friend>(friend, HttpStatus.OK);	
	}

	@PostMapping(value="/friend")
	 public ResponseEntity<Friend> createFriend(@RequestBody Friend friend){
		 Logger.debug("Cslling method createFriend");
		 
		 if(friendDAO.get(friend.getFriendid()) == null)
		 {	 
			 friendDAO.saveorUpdate(friend);
			 return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		 }
		 return new ResponseEntity<Friend>(HttpStatus.CONFLICT);
	 }
	
	 @DeleteMapping("/friend/{friendid}")
	 public ResponseEntity<Friend> deleteFriend(@PathVariable int friendid){
		 Logger.debug("Calling method deleteFriend with the friendid" + friendid);
		 
		 if (friendDAO.get(friendid)== null){
			 return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		 }
		 friendDAO.delete(friendid);
		 return new ResponseEntity<Friend>(HttpStatus.OK);
	 }	
	 
	 
	 
	 @PutMapping("/friend/{friendid}")
	 public ResponseEntity<Friend> updateFriend(@PathVariable int friendid,@RequestBody Friend friend){
		 Logger.debug("Calling method updateFriend with the friendid" + friendid);
		 
		 if (friendDAO.get(friendid)== null){
			 return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		 }
		 friendDAO.saveorUpdate(friend);
		 return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	 }	
}