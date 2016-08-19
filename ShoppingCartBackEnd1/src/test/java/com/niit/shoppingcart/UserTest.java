package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {

	public static void main(String[] args) {

	
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		User user = (User) context.getBean("user");
		
		
		user.setId("PMS1234");
		user.setName("prasad");
		user.setDesc("From Pune");
		user.setMobileno("9561786772");
		user.setEmail("prasadsawant023@gmail.com");
		user.setPassword("prasad123");
		user.setadmin((byte)1);
		
		System.out.println("Hi");
		
		userDAO.saveOrUpdate(user);
		
		System.out.println("save");
		if(userDAO.get("prasad")==null){
			System.out.println("Category Does Not Exist");
		}else{
			System.out.println("Category Exist....");
		}
	}

}
