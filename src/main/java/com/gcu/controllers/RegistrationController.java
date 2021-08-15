package com.gcu.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
@RequestMapping("/register")
public class RegistrationController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute(new UserModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public ModelAndView doRegister(UserModel userModel, BindingResult bindingResult, Model model) throws ParseException {
		ModelAndView mv = new ModelAndView();

		System.out.println(String.format("You entered username of %s and password of %s", userModel.getEmail(), userModel.getFirstName()));		
		if (bindingResult.hasErrors()) {
			mv.setViewName("register");
			return mv;
		}		

		mv.setViewName("index");
		return mv;
	}
}