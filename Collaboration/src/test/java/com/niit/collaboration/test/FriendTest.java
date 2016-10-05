package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

public class FriendTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		FriendDAO friendDAO = (FriendDAO) context.getBean("friendDAO");
		
		Friend friend = (Friend) context.getBean("friend");
		
		friendDAO.saveorUpdate(friend);

	}

}
