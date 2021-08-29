package com.gcu.service;

import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public interface BusinessServiceInterface {
	public boolean storeUserInDB(UserModel user);
	public boolean doPost(PostModel post);
	public void init();
	public void destroy();
}
