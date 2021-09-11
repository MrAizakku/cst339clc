package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.service.DataAccessService;
import com.gcu.service.SecurityBusinessService;
import com.gcu.service.SecurityBusinessServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name="securityBusinessService", initMethod="init", destroyMethod="destroy")
	public SecurityBusinessServiceInterface getSecuirtyBusinessService() {
		return new SecurityBusinessService();
	}

	@Bean(name="dataAccessService", initMethod="init", destroyMethod="destroy")
	public DataAccessService getDataAccessService() {
		return new DataAccessService();
	}

}
