package com.gcu.service;

import com.gcu.models.UserModel;

public interface BusinessServiceInterface {
	public boolean storeUserInDB(UserModel user);
	public void init();
	public void destroy();
}
