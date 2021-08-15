package com.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.models.UserModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute(new UserModel());
		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(UserModel userModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("You entered username of %s and password of %s", userModel.getEmail(),
				userModel.getPassword()));
		return "login";
	}

}
