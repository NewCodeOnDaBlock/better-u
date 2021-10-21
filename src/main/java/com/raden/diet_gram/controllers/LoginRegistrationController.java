package com.raden.diet_gram.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raden.diet_gram.models.LoginUser;
import com.raden.diet_gram.models.User;
import com.raden.diet_gram.services.UserService;

@Controller
public class LoginRegistrationController {
	
	@Autowired
	public UserService userService;

	@RequestMapping("/")
	public String renderRegistrationPage(@ModelAttribute("newUser")User user) {
		
		return "registration.jsp";
	}
	
	@RequestMapping("/login")
	public String renderLoginPage(@ModelAttribute("newLogin")LoginUser newLogin) {
		
		return "login.jsp";
	}
	
	
	 @RequestMapping(value="/register", method=RequestMethod.POST)
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	    		BindingResult result, Model model, HttpSession session) {
	    	userService.registerNewUser(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "registration.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/dashboard";
	    }
	 
	 
	  @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userService.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/dashboard";
	    
	    	}
	  
	  	@RequestMapping("/logout")
	    public String logOut(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
	 
	 
}
