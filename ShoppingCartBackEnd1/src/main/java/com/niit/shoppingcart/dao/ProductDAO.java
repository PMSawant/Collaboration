package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public void saveOrUpdate(Product product);

	public void delete(String id);

	public Product get(String id);

	public List<Product> list();

}
