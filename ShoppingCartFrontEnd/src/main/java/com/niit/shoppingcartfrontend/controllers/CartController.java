package com.niit.shoppingcartfrontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Controller
public class CartController {

@Autowired
private CartDAO cartDAO;

@Autowired
private ProductDAO productDAO;

@Autowired
private CategoryDAO categoryDAO;


@RequestMapping(value = "/myCart", method = RequestMethod.GET)
public String myCart(Model model) {
	model.addAttribute("category", new Category());
	model.addAttribute("categoryList", categoryDAO.list());

	model.addAttribute("cart", new Cart());
	model.addAttribute("cartList", this.cartDAO.list());
	model.addAttribute("totalAmount", cartDAO.getTotalAmount("user")); 
	model.addAttribute("displayCart", "true");
	return "/index";
}

	@RequestMapping(value= "/cart/add/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") String id){
		
	 Product product =	 productDAO.get(id);
	 Cart cart = new Cart();
	 cart.setPrice(product.getPrice());
	 cart.setProductName(product.getName());
	 cart.setQuantity(1);
	 cart.setUserID("user"); 
	 cart.setStatus('N');   
		cartDAO.saveOrUpdate(cart);
		return "redirect:/index";
		
	}
	
	@RequestMapping("cart/remove/{id}")
    public String removeCart(@PathVariable("id") String id,ModelMap model) {
		
		cartDAO.delete(id);
		model.addAttribute("message","Successfully removed");
        return "redirect:/index";
    }
 
    @RequestMapping("cart/edit/{id}")
    public String editCart(@PathVariable("id") String id, Model model){
    	System.out.println("editCart");
        model.addAttribute("cart", this.cartDAO.get(id));
        model.addAttribute("listCarts", this.cartDAO.list());
        return "cart";
    }
}