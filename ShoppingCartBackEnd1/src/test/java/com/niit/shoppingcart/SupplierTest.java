package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
		Supplier supplier = (Supplier) context.getBean("supplier");
		
		supplier.setId("sup03");
		supplier.setName("supNam1");
		supplier.setAdd("supplier add1");
		System.out.println("Hi");
		
		supplierDAO.saveOrUpdate(supplier);
		
		System.out.println("save");
		if(supplierDAO.get("sup01")==null){
			System.out.println("Supplier Does Not Exist");
		}else{
			System.out.println("Supplier Exist....");
		}
	}

}
