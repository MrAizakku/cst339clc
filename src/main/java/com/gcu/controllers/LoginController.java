/* ---------------------------------------------------------------------------
 * Name      : Group Purple
 * Members   : D. Johnson, I Tucker, I. Debenedetto, K. Kubli, K. Lamb
 * Date      : 2021-08-14
 * Class     : CST-339 Computer Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. This is the login controller that directs a user to the login page and runs the doLogin function. no authentication is taking place as of yet.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 D. Johnson          Initial Creation
 *
 *
 */
package com.gcu.controllers;

import javax.validation.Valid;

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
	public ModelAndView doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		System.out.println(String.format("You entered username of %s and password of %s", userModel.getEmail(), userModel.getPassword()));
		ModelAndView mv = new ModelAndView();
		
		//Note, i personally do not believe we should provide validation for login as it provides hints - but it is required by the CLC guideleines.
		if(bindingResult.getFieldError("email") != null || bindingResult.getFieldError("password") != null) {
			mv.setViewName("login");
			return mv;
		}
				
		//authenticate - return true or false.
		//load userModel
		mv.addObject("userData", userModel);
		mv.setViewName("index");
		return mv;
	}
}
