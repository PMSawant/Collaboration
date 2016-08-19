package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {

	public static void main(String[] args) {

		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		Category category = (Category) context.getBean("category");
		
		category.setId("cat0");
		category.setName("Prasad");
		category.setDesc("Prasad cat0");
		System.out.println("Hi");
		
		categoryDAO.saveOrUpdate(category);
		
		System.out.println("save");
		if(categoryDAO.get("cat001")==null){
			System.out.println("Category Does Not Exist");
		}else{
			System.out.println("Category Exist....");
		}
	}

}
