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

import com.RestExample.model.Blog;
import com.RestExample.services.BlogService;

@RestController
public class BlogController {

	@Autowired
	private BlogService blogService;

	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	@RequestMapping(value="/blog",method=RequestMethod.GET)
	public @ResponseBody List<Blog> getAllBlogs(){
		System.out.println(blogService.getAllBlogs());
		return blogService.getAllBlogs();
	}
	
	@RequestMapping(value="/blog/{id}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getBlogById(@PathVariable(value="id") int id){
		Blog blog=blogService.getBlogById(id);
		if(blog==null)
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}

	@RequestMapping(value="/blog",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> servet to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createBlog(@RequestBody Blog blog,
			UriComponentsBuilder build){
		blogService.saveBlog(blog);
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/
		URI urilocation=
				build.path("/blog/")
				.path(String.valueOf(blog.getBlogId()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/blog/{id}",method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Blog> updateBlog(
			@PathVariable int id,@RequestBody Blog blog){
		//Blog -> from client
		//updatedBlog -> from database 
		Blog updatedBlog=blogService.updateBlog(id, blog);
		if(blog==null)
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Blog>(updatedBlog,HttpStatus.OK);	
	}
	
	
	@RequestMapping(value={"/blog/{id}"},method={RequestMethod.DELETE})
	public ResponseEntity<Void> deleteBlog(@PathVariable int id){

		Blog blog=blogService.getBlogById(id);
		if(blog==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		blogService.deletBlog(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}
