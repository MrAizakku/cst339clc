package com.gcu.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@GetMapping("")
	public String logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
        httpSession.invalidate();
		return "index";
	}
}
