package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

public class BlogTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");
		
		Blog blog = (Blog) context.getBean("blog");
		
		blogDAO.saveorUpdate(blog);
		

	}

}
