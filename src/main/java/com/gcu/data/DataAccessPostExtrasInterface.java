package com.gcu.data;

import java.util.List;

import com.gcu.models.PostModel;

public interface DataAccessPostExtrasInterface <T> {
	public Double calculateRatingPercentage(int id);
	public List<PostModel> findAllByUserId(int id);
}
