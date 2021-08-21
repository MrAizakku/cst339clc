package com.gcu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean(name="securityBusinessService", initMethod="init", destroyMethod="destroy")
	public SecurityBusinessServiceInterface getSecuirtyBusinessService() {
		return new SecurityBusinessService();
	}

	@Bean(name="businessService", initMethod="init", destroyMethod="destroy")
	public BusinessServiceInterface getBusinessService() {
		return new BusinessService();
	}

	@Bean(name="dataAccessService", initMethod="init", destroyMethod="destroy")
	public DataAccessService getDataAccessService() {
		return new DataAccessService();
	}

}
