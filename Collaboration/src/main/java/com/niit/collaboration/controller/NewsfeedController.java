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

import com.niit.collaboration.dao.NewsfeedDAO;
import com.niit.collaboration.model.Newsfeed;

@RestController
public class NewsfeedController {

	private static final Logger Logger =
			LoggerFactory.getLogger(NewsfeedController.class);
	
	@Autowired
	private NewsfeedDAO newsfeedDAO;
	
	@Autowired
	private Newsfeed newsfeed;
	
	
	@GetMapping("/newsfeeds")
	public ResponseEntity<List<Newsfeed>> getNewsfeeds(){
	Logger.debug("Calling method getNewsfeeds");
	List<Newsfeed> list=  newsfeedDAO.list();		
	if(list.isEmpty())
		{
			return new ResponseEntity<List<Newsfeed>>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<List<Newsfeed>>(HttpStatus.OK); 
	}
	
	@GetMapping("/newsfeed/{newsfeedid}")
	public ResponseEntity<Newsfeed> getNewsfeed(@PathVariable("newsfeedid") int newsfeedid) {
		Logger.debug("Calling method getJob with newsfeedid" + newsfeedid);
		newsfeed = newsfeedDAO.get(newsfeedid);
		if (newsfeed == null)
		{
		return new ResponseEntity<Newsfeed>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<Newsfeed>(newsfeed, HttpStatus.OK);	
	}
			
	
	 @PostMapping(value="/newsfeed")
	 public ResponseEntity<Newsfeed> createNewsfeed(@RequestBody Newsfeed newsfeed){
		 Logger.debug("Calling method createNewsfeed");
		 
		 if(newsfeedDAO.get(newsfeed.getNewsfeedid()) == null)
		 {	 
			 newsfeedDAO.saveorUpdate(newsfeed);
			 return new ResponseEntity<Newsfeed>(newsfeed, HttpStatus.OK);
		 }
		 return new ResponseEntity<Newsfeed>(HttpStatus.CONFLICT);
	 }
	 
	 
	 @DeleteMapping("/newsfeed/{newsfeedid}")
	 public ResponseEntity<Newsfeed> deleteNewsfeed(@PathVariable int newsfeedid){
		 Logger.debug("Calling method deleteNewsfeed with the Newsfeedid" + newsfeedid);
		 
		 if (newsfeedDAO.get(newsfeedid)== null){
			 return new ResponseEntity<Newsfeed>(HttpStatus.NOT_FOUND);
		 }
		 newsfeedDAO.delete(newsfeedid);
		 return new ResponseEntity<Newsfeed>(HttpStatus.OK);
	 }	
	 
	 @PutMapping("/newsfeed/{newsfeedid}")
	 public ResponseEntity<Newsfeed> updateNewsfeed(@PathVariable int newsfeedid,@RequestBody Newsfeed newsfeed){
		 Logger.debug("Calling method updateNewsfeed with the Newsfeedid" + newsfeedid);
		 
		 if (newsfeedDAO.get(newsfeedid)== null){
			 return new ResponseEntity<Newsfeed>(HttpStatus.NOT_FOUND);
		 }
		 newsfeedDAO.saveorUpdate(newsfeed);
		 return new ResponseEntity<Newsfeed>(newsfeed,HttpStatus.OK);
	 }	
}
