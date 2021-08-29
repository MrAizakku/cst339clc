package com.gcu.data;

public interface DataAccessUserExtrasInterface <T>
{
	public Boolean verifyUser(String email, String password);
	public Boolean isUserAdmin(T t);
}
