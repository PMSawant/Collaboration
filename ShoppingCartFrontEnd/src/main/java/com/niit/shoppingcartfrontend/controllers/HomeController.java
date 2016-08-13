package com.niit.shoppingcartfrontend.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {
	
@Autowired
Category category;

@Autowired
CategoryDAO categoryDAO;

@Autowired
User user;

@Autowired
UserDAO userDAO;

	
@RequestMapping("/")
public ModelAndView onload (HttpSession session) {
	ModelAndView mv = new ModelAndView("/index");
	session.setAttribute("category",category);
	session.setAttribute("categoryList", categoryDAO.list());
	return mv;
	 }
	

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		userDAO.saveOrUpdate(user);
		ModelAndView mv  = new ModelAndView("/index");
		mv.addObject("successMessage", "You are successfully register");
		return mv; 
		}

	@RequestMapping("/registerHere")
	public ModelAndView registerHere() {
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegisterHere", "true");
		return mv;
	}

	@RequestMapping("/loginHere")
	public ModelAndView loginHere() {
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("user", new User());
		mv.addObject("isUserClickedLoginHere", "true");
		return mv;
	}
}