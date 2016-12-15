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

import com.RestExample.model.Forum;
import com.RestExample.services.ForumService;

@RestController
public class ForumController {
	
	@Autowired
	private ForumService forumService;

	public ForumService getForumService() {
		return forumService;
	}
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}
	
		
	@RequestMapping(value="/forum",method=RequestMethod.GET)
	public @ResponseBody List<Forum> getAllForums(){
		System.out.println(forumService.getAllForums());
		return forumService.getAllForums();
		
	}

	
	@RequestMapping(value="/forum/{id}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForumById(@PathVariable(value="id") int id){
		Forum forum=forumService.getForumById(id);
		if(forum==null)
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/forum",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> servet to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createForum(@RequestBody Forum forum,
			UriComponentsBuilder build){
		forumService.saveForum(forum);
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/
		URI urilocation=
				build.path("/forum/")
				.path(String.valueOf(forum.getForumId()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/forum/{id}",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Forum> updateForum(
			@PathVariable int id,@RequestBody Forum forum){
		//Forum -> from client
		//updatedBlog -> from database 
		Forum updatedForum=forumService.updateForum(id, forum);
		if(forum==null)
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Forum>(updatedForum,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value={"/forum/{id}"},method={RequestMethod.DELETE})
	public ResponseEntity<Void> deleteForum(@PathVariable int id){

		Forum forum=forumService.getForumById(id);
		if(forum==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		forumService.deletForum(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
