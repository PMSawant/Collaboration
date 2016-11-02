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

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UserController {

	
	private static final Logger Logger =
			LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	
	@GetMapping("/Users")
	public ResponseEntity<List<User>> getUsers(){
	Logger.debug("Calling method getUsers");
	List<User> list=  userDAO.list();		
	if(list.isEmpty())
		{
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<List<User>>(HttpStatus.OK); 
	}
	
	@GetMapping("/user/{mailid}")
	public ResponseEntity<User> getUser(@PathVariable("mailid") String mailid) {
		Logger.debug("Calling method getUser with Userid" + mailid);
		user = userDAO.get(mailid);
		if (user == null)
		{
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<User>(user, HttpStatus.OK);	
	}
			
	
	 @PostMapping(value="/user")
	 public ResponseEntity<User> createUser(@RequestBody User user){
		 Logger.debug("Cslling method createUser");
		 
		 if(userDAO.get(user.getMailid()) == null)
		 {	 
			 userDAO.saveorUpdate(user);
			 return new ResponseEntity<User>(user, HttpStatus.OK);
		 }
		 return new ResponseEntity<User>(HttpStatus.CONFLICT);
	 }
	 
	 
	 @DeleteMapping("/user/{mailid}")
	 public ResponseEntity<User> deleteUser(@PathVariable String mailid){
		 Logger.debug("Calling method deleteuser with the mailid" + mailid);
		 
		 if (userDAO.get(mailid)== null){
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
		 userDAO.delete(mailid);
		 return new ResponseEntity<User>(HttpStatus.OK);
	 }	
	 
	 @PutMapping("/user/{mailid}")
	 public ResponseEntity<User> updateUser(@PathVariable String mailid,@RequestBody User user){
		 Logger.debug("Calling method updateuser with the mailid" + mailid);
		 
		 if (userDAO.get(mailid)== null){
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
		 userDAO.saveorUpdate(user);
		 return new ResponseEntity<User>(user,HttpStatus.OK);
	 }	
}
