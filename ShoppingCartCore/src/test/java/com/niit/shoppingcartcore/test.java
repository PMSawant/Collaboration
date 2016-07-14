package com.niit.shoppingcartcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
		Context.scan("com.niit.shoppingcartcore");
		Context.refresh();
		
		Context.getBean("category");
		
		System.out.println("Category is created");
	}
	

}

