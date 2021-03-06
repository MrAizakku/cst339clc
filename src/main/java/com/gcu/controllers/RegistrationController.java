package com.gcu.controllers;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.models.UserModel;
import com.gcu.service.BusinessServiceInterface;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group Purple
 * Members   : D. Johnson, I Tucker, I. Debenedetto, K. Kubli, K. Lamb
 * Date      : 2021-08-14
 * Class     : CST-339 Java Programming III
 * Professor : Brandom Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Controller - Registration
 * 2.
 * 3.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 Team                Initial Creation
 *
 *
 */

@Controller
@SessionAttributes("userData")
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private BusinessServiceInterface bservice;
	
	/**
	 * Method to handle registration selection
	 * @param model - hold user information
	 * @return - string for the the next page
	 */
	@GetMapping("")
	public String display(Model model) {
		model.addAttribute(new UserModel());
		return "register";
	}
	
	/**
	 * Method to handle registration input
	 * @param userModel - user information
	 * @param bindingResult - used for field requirement error checking
	 * @param model - information returned from the registration view
	 * @return ModelAndView - info containing both the model and view to send user to next
	 */
	@PostMapping("/doRegister")
	public ModelAndView doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		System.out.println("doRegister");
		ModelAndView mv = new ModelAndView();
		/**
		 * User's should be at least 13 years of age
		 * These variables exist to determine the age of the user
		 */
		LocalDate today = LocalDate.now();
		LocalDate birthdate = LocalDate.parse(userModel.getBirthdate());
		Period p = Period.between(birthdate, today);

		System.out.println(String.format("You entered username of %s and password of %s and Birthdate of %s", userModel.getEmail(), userModel.getPassword(), userModel.getBirthdate()));
		System.out.println("Today's date: " + today);
		System.out.println(String.format("User attempting to register is %d years old", p.getYears()));
		if (bindingResult.hasErrors()) {
			mv.setViewName("register");
			return mv;
		}		
		if (p.getYears() < 13) {
			mv.setViewName("register");
			return mv;
		}
		String encoded = new BCryptPasswordEncoder().encode(userModel.getPassword());
		userModel.setPassword(encoded);
		boolean success = bservice.storeUserInDB(userModel);
		
		if(!success) {
			mv.setViewName("register");
			return mv;
		}
		mv.setViewName("index");
		return mv;
	}
}