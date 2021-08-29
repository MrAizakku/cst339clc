package com.gcu.service;

import com.gcu.models.PostModel;
import com.gcu.models.UserModel;

public interface DataAccessServiceInterface {
	public boolean storeUserInDB(UserModel user);
	public void init();
	public void destroy();
	public boolean doPost(PostModel post);
}
