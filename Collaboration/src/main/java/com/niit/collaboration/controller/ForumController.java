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

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

@RestController
public class ForumController {

	private static final Logger Logger =
			LoggerFactory.getLogger(ForumController.class);
	
	@Autowired
	private ForumDAO forumDAO;
	
	@Autowired
	private Forum forum;
	
	@GetMapping("/forums")
	public ResponseEntity<List<Forum>> getForum(){
	Logger.debug("Calling method getForum");
	List<Forum> list=  forumDAO.list();		
	if(list.isEmpty())
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<List<Forum>>(HttpStatus.OK); 
	}
	
	@GetMapping("/forum/{forumid}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumid") int forumid) {
		Logger.debug("Calling method getForum with forumid" + forumid);
		forum = forumDAO.get(forumid);
		if (forum == null)
		{
		return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<Forum>(forum, HttpStatus.OK);	
	}
	

	 @PostMapping(value="/forum")
	 public ResponseEntity<Forum> createForum(@RequestBody Forum forum){
		 Logger.debug("Cslling method createForum");
		 
		 if(forumDAO.get(forum.getForumid()) == null)
		 {	 
			 forumDAO.saveorUpdate(forum);
			 return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		 }
		 return new ResponseEntity<Forum>(HttpStatus.CONFLICT);
	 }
	 
	 
 
	 
	 @DeleteMapping("/forum/{forumid}")
	 public ResponseEntity<Forum> deleteForum(@PathVariable int forumid){
		 Logger.debug("Calling method deleteForum with the forumid" + forumid);
		 
		 if (forumDAO.get(forumid)== null){
			 return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		 }
		 forumDAO.delete(forumid);
		 return new ResponseEntity<Forum>(HttpStatus.OK);
	 }	
	 
	 
	 
	 @PutMapping("/forum/{forumid}")
	 public ResponseEntity<Forum> updateForum(@PathVariable int forumid,@RequestBody Forum forum){
		 Logger.debug("Calling method updateForum with the forumid" + forumid);
		 
		 if (forumDAO.get(forumid)== null){
			 return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		 }
		 forumDAO.saveorUpdate(forum);
		 return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	 }	
}
