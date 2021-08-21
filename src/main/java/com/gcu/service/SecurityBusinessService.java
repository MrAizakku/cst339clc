package com.gcu.service;

public class SecurityBusinessService implements SecurityBusinessServiceInterface {
	
	public boolean authenticate(String username, String password) {
		
		if (!username.trim().isEmpty() && !password.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public void init() {
		System.out.println("SBS Init");
	}

	@Override
	public void destroy() {
		System.out.println("SBS Destroy");
	}

}
