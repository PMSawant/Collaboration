/*package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

public class CartTest {

	public static void main(String[] args) {

	
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		
		Cart cart = (Cart) context.getBean("cart");
		
		
		
		cart.getId();
		cart.setUserID("BDS1234");
		cart.setProductName("SAMSUNG");
		cart.setPrice(75000);
		cart.setQuantity(2);
		cart.setTotal(150000);
		cart.setStatus('Y');
		
		System.out.println("Hi");
		
		cartDAO.saveOrUpdate(cart);
	}
}
*/