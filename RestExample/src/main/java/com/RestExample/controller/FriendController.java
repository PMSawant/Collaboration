package com.RestExample.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.RestExample.model.Friend;
import com.RestExample.services.FriendService;

@RestController
public class FriendController {

	
	@Autowired
	private FriendService friendService;

	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	
	@RequestMapping(value="/friend",method=RequestMethod.GET)
	public @ResponseBody List<Friend> getAllFriends(){
		System.out.println(friendService.getAllFriends());
		return friendService.getAllFriends();
	}
	
	
	@RequestMapping(value="/friend/{id}",method=RequestMethod.GET)
	public ResponseEntity<Friend> getFriendById(@PathVariable(value="id") int id){
		Friend friend=friendService.getFriendById(id);
		if(friend==null)
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/friend",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> servet to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createFriend(@RequestBody Friend friend,
			UriComponentsBuilder build){
		friendService.saveFriend(friend);
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/
		URI urilocation=
				build.path("/friend/")
				.path(String.valueOf(friend.getFriendId()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(value="/friend/{id}",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Friend> updateFriend(
			@PathVariable int id,@RequestBody Friend friend){
		//Blog -> from client
		//updatedBlog -> from database 
		Friend updatedFriend=friendService.updateFriend(id, friend);
		if(friend==null)
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Friend>(updatedFriend,HttpStatus.OK);	
	}
	
	@RequestMapping(value={"/friend/{id}"},method={RequestMethod.DELETE})
	public ResponseEntity<Void> deleteFriend(@PathVariable int id){

		Friend friend=friendService.getFriendById(id);
		if(friend==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		friendService.deletFriend(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
