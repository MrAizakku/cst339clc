package com.gcu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.models.UserModel;

@Configuration
public class SpringConfig {
	
	@Bean(name="tempUser")
	public UserModel getTempUser() {
		return new UserModel();
	}

}
