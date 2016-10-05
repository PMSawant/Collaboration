package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.NewsfeedDAO;
import com.niit.collaboration.model.Newsfeed;

public class NewsfeedTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		NewsfeedDAO newsfeedDAO = (NewsfeedDAO) context.getBean("newsfeedDAO");
		
		Newsfeed newsfeed = (Newsfeed) context.getBean("newsfeed");
		
		newsfeedDAO.saveorUpdate(newsfeed);
		

	}

}
