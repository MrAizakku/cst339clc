package com.gcu.service;

import com.gcu.models.UserModel;

public interface SecurityBusinessServiceInterface {
	public boolean authenticate(String username, String password);
	public boolean inputsValid(String username, String password);
	public UserModel findByEmail(String email);
	public void init();
	public void destroy();
}

