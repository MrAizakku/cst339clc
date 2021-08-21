package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessService {
	
	public boolean authenticate(String username, String password) {
		
		if (!username.trim().isEmpty() && !password.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}

}
