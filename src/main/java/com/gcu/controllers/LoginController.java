package com.gcu.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.models.UserModel;
import com.gcu.service.BusinessServiceInterface;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private BusinessServiceInterface bservice;
	
	private String email;
	private String password;

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute(new UserModel());
		return "login";
	}

	@PostMapping("/doLogin")
	public ModelAndView doLogin(@Valid UserModel userModel, BindingResult bindingResult, HttpSession session) {
		email = userModel.getEmail();
		password = userModel.getPassword();
		System.out.println(String.format("You entered email of %s and password of %s", email, password));
//		temp.setEmail(userModel.getEmail());
//		temp.setPassword(userModel.getPassword());
		ModelAndView mv = new ModelAndView();
		
		//Note, i personally do not believe we should provide validation for login as it provides hints - but it is required by the CLC guideleines.
		if(bindingResult.getFieldError("email") != null || bindingResult.getFieldError("password") != null) {
			mv.setViewName("login");
			return mv;
		}
					
		//authenticate - returns true if fields are not empty or blank 
		if (bservice.inputsValid(email, password)) {
			System.out.println("Valid inputs. " + userModel.getEmail());
			
			// verify user exists in db
			if (bservice.authenticate(email, password)) {
				userModel = bservice.findByEmail(email);
				session.setAttribute("userData", userModel);
				mv.setViewName("index");
				return mv;
			} else {
				// return user to login if verification fails
				mv.setViewName("login");
				return mv;
			}
			
		} else {
			//return user to login page to try again
			mv.setViewName("login");
			return mv;
		}
		

	}

}
