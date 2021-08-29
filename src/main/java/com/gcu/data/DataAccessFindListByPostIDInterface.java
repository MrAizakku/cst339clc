package com.gcu.data;

import java.util.List;

public interface DataAccessFindListByPostIDInterface <T>
{
	public List<T> findListByPostID(int id);
}
