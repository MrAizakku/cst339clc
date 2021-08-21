package com.gcu.controllers;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.models.UserModel;
import com.gcu.service.SecurityBusinessService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private SecurityBusinessService security;
	
//	@Autowired
//	private UserModel temp;

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute(new UserModel());
		return "login";
	}

	@PostMapping("/doLogin")
	public ModelAndView doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("You entered email of %s and password of %s", userModel.getEmail(), userModel.getPassword()));
//		temp.setEmail(userModel.getEmail());
//		temp.setPassword(userModel.getPassword());
		ModelAndView mv = new ModelAndView();
		
		//Note, i personally do not believe we should provide validation for login as it provides hints - but it is required by the CLC guideleines.
		if(bindingResult.getFieldError("email") != null || bindingResult.getFieldError("password") != null) {
			mv.setViewName("login");
			return mv;
		}
		
		
				
		//authenticate - returns true if fields are not empty or blank 
		if (security.authenticate(userModel.getEmail(), userModel.getPassword())) {
			//load userModel
			mv.addObject("userData", userModel);
			mv.setViewName("index");
			return mv;
		} else {
			//return user to login page to try again
			mv.setViewName("login");
			return mv;
		}
		

	}

}
