package com.gcu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.models.UserModel;

@Controller
@SessionAttributes("userData")
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute(new UserModel());
		return "login";
	}

	@PostMapping("/doLogin")
	public ModelAndView doLogin(UserModel userModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("You entered username of %s and password of %s", userModel.getEmail(),
				userModel.getPassword()));
		
		//authenticate
		//load userModel
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userData", userModel);
		mv.setViewName("index");
		return mv;
	}
}
