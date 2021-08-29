package com.gcu.data;

import com.gcu.models.UserModel;

public interface DataAccessUserExtrasInterface <T>
{
	public Boolean verifyUser(String email, String password);
	public Boolean isUserAdmin(T t);
	public UserModel findByEmail(String email);
}
