package com.niit.shoppingCartfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	Logger log = LoggerFactory.getLogger(HomeController.class);
	
@Autowired
User user;

@Autowired
private CategoryDAO categoryDAO;

@Autowired
private UserDAO userDAO;

@Autowired
private Category category;

//     ${categoryList}
@RequestMapping("/")
public ModelAndView onLoad(HttpSession session)
	{
	log.debug("Starting of the method onLoad");
	ModelAndView mv = new ModelAndView("/home");
	session.setAttribute("category", category);
	session.setAttribute("categoryList", categoryDAO.list());
	log.debug("Ending of the method onLoad");
	return mv;
	}

// ${successMessage}
@RequestMapping(value = "user/register", method = RequestMethod.POST)
public ModelAndView registerUser(@ModelAttribute User user) 
	{
	userDAO.saveOrUpdate(user);
	ModelAndView mv  = new ModelAndView("/home");
	mv.addObject("successMessage", "You are successfully register");
	
	return mv;
	}

@RequestMapping("/registerHere")
public ModelAndView registerHere() 	
	{
	ModelAndView mv = new ModelAndView("/home");
	mv.addObject("user", User);
	mv.addObject("isUserClickedRegisterHere", "true");
	return mv;
	}

@RequestMapping("/loginHere")
public ModelAndView loginHere()
	{
	ModelAndView mv = new ModelAndView("/home");
	mv.addObject("user", new User());
	mv.addObject("isUserClickedLoginHere", "true");
	return mv;
	}	
}
