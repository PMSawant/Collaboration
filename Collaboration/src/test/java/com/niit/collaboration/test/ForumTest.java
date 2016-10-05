package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

public class ForumTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		
		Forum forum = (Forum) context.getBean("forum");
		
		forumDAO.saveorUpdate(forum);
		

	}


}
