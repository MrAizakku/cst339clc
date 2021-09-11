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
 * 1. This is the home controller that specifies paths to direct a user to the index/home page.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/13/21 I. Tucker           Initial Creation
 *
 *
 */
package com.gcu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gcu.models.UserModel;
import com.gcu.service.BusinessServiceInterface;

import org.springframework.security.core.userdetails.UserDetails;

@Controller
@SessionAttributes("userData")
public class HomeController {
	
	@Autowired
	private BusinessServiceInterface bservice;
	
	@GetMapping("/")
	public String home(HttpSession session) {	
		System.out.println(session.getAttribute("userData"));
		return "index";
	}	

	@GetMapping("/loggedIn")
	public String loggedIn(HttpSession session) {		
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
			UserModel userModel = bservice.findByEmail(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
			session.setAttribute("userData", userModel);
		}
		return "index";
	}
}