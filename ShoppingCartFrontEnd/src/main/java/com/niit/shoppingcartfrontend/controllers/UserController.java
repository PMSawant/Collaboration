package com.niit.shoppingcartfrontend.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);

@Autowired
Category category;

@Autowired
ProductDAO productDAO;
@Autowired
CategoryDAO categoryDAO;

@Autowired
User user;

@Autowired
UserDAO userDAO;

@RequestMapping("/login")
public ModelAndView login(@RequestParam(value = "name") String userID,
		@RequestParam(value = "password") String password, HttpSession session) {
	log.debug("Starting of the method login");
	log.info("userID is {}  password is {}", userID, password);
	ModelAndView mv = new ModelAndView("/index");
	boolean isValidUser = userDAO.isValidUser( userID, password);

	if (isValidUser == true) {
		user = userDAO.get(userID);
		session.setAttribute("loggedInUser", user.getName());
		if (user.getAdmin() == 1) {
			mv.addObject("isAdmin", "true");

		} else {
			System.out.println("########User");
			mv.addObject("isAdmin", "false");
			mv.addObject("productList", productDAO.list());
			
		}

	} else {
		mv.addObject("invalidCredentials", "true");
		mv.addObject("errorMessage", "Invalid Credentials");
		
	}log.debug("Ending of the method login");
	return mv;
}

 
@RequestMapping("/logout")
public ModelAndView logout(HttpServletRequest request, HttpSession session) {
	ModelAndView mv = new ModelAndView("/index");
	session.invalidate();
	session = request.getSession(true);
	session.setAttribute("category", category);
	session.setAttribute("categoryList", categoryDAO.list());

	mv.addObject("logoutMessage", "You successfully logged out");
	mv.addObject("loggedOut", "true");

	return mv;
 }
}
	