package com.niit.shoppingcartfrontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class ProductController {
	
@Autowired
private Product product;

@Autowired
private Supplier supplier;

@Autowired
private Category category;

@Autowired
private CategoryDAO categoryDAO;

@Autowired
private SupplierDAO supplierDAO;

@Autowired
private ProductDAO productDAO;



@RequestMapping(value = "/products", method = RequestMethod.GET)
public String listProducts(Model model) {
	model.addAttribute("product", product);
	model.addAttribute("category",  category);
	model.addAttribute("supplier",  supplier);
	model.addAttribute("productList", this.productDAO.list());
	model.addAttribute("categoryList", this.categoryDAO.list());
	model.addAttribute("supplierList", this.supplierDAO.list());
	return "product";

	}

@RequestMapping(value = "/product/add", method = RequestMethod.POST)
public String addProduct(@ModelAttribute("product") Product product) {

	productDAO.saveOrUpdate(product);
	return "redirect:/manageProducts";
	}

@RequestMapping("product/remove/{id}")
public String removeProduct(@PathVariable("id") String id, ModelMap model) {
		productDAO.delete(id);
		return "redirect:/manageProducts";
	}


@RequestMapping("product/edit/{id}")
public String editProduct(@PathVariable("id") String id, Model model) {
	model.addAttribute("product", this.productDAO.get(id));
	model.addAttribute("listProducts", this.productDAO.list());
	model.addAttribute("categoryList", this.categoryDAO.list());
	model.addAttribute("supplierList", this.supplierDAO.list());
	return "product";
	}
}
