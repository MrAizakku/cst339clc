package com.gcu.service;

public interface SecurityBusinessServiceInterface {
	public boolean authenticate(String username, String password);
	public boolean inputsValid(String username, String password);
	public void init();
	public void destroy();
}

