package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserTest {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		User user = (User) context.getBean("user");
		
		user.setMailid("prasad@gmail.com");
		userDAO.saveorUpdate(user);
		
		
	}
	
	
	
	


}
