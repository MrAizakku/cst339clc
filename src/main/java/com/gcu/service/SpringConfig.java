package com.gcu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	public SecurityBusinessServiceInterface getSecuirtyBusinessService() {
		return new SecurityBusinessService();
	}

}
