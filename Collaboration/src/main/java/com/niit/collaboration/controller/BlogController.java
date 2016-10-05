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

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

@RestController
public class BlogController {

	private static final Logger Logger =
			LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private Blog blog;
	
	
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getBlogs(){
	Logger.debug("Calling method getBlogs");
	List<Blog> list=  blogDAO.list();		
	if(list.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
	return new ResponseEntity<List<Blog>>(HttpStatus.OK); 
	}
	
	@GetMapping("/blog/{blogid}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogid") int blogid) {
		Logger.debug("Calling method getBlog with blogid" + blogid);
		blog = blogDAO.get(blogid);
		if (blog == null)
		{
		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
	return new ResponseEntity<Blog>(blog, HttpStatus.OK);	
	}
			
	
	 @PostMapping(value="/blog")
	 public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		 Logger.debug("Cslling method createBlog");
		 
		 if(blogDAO.get(blog.getBlogid()) == null)
		 {	 
			 blogDAO.saveorUpdate(blog);
			 return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		 }
		 return new ResponseEntity<Blog>(HttpStatus.CONFLICT);
	 }
	 
	 
	 @DeleteMapping("/blog/{blogid}")
	 public ResponseEntity<Blog> deleteBlog(@PathVariable int blogid){
		 Logger.debug("Calling method deleteBlog eith the blogid" + blogid);
		 
		 if (blogDAO.get(blogid)== null){
			 return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		 }
		 blogDAO.delete(blogid);
		 return new ResponseEntity<Blog>(HttpStatus.OK);
	 }	
	 
	 @PutMapping("/blog/{blogid}")
	 public ResponseEntity<Blog> updateBlog(@PathVariable int blogid,@RequestBody Blog blog){
		 Logger.debug("Calling method updateBlog eith the blogid" + blogid);
		 
		 if (blogDAO.get(blogid)== null){
			 return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		 }
		 blogDAO.saveorUpdate(blog);
		 return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	 }	
}