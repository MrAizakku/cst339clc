package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.service.DataAccessService;
import com.gcu.service.SecurityBusinessService;
import com.gcu.service.SecurityBusinessServiceInterface;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group Purple
 * Members   : D. Johnson, I Tucker, I. Debenedetto, K. Kubli, K. Lamb
 * Date      : 2021-08-14
 * Class     : CST-339 Java Programming III
 * Professor : Brandom Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Main Application - Bean Configuration
 * 2.
 * 3.
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 08/14/21 Team                Initial Creation
 *
 *
 */

@Configuration
public class SpringConfig {

	/**
	 * Configure Security service bean
	 * @return SecurityBusinessServiceInterface
	 */
	@Bean(name="securityBusinessService", initMethod="init", destroyMethod="destroy")
	public SecurityBusinessServiceInterface getSecuirtyBusinessService() {
		return new SecurityBusinessService();
	}

	/**
	 * Configure Data access service bean
	 * @return DataAccessService
	 */
	@Bean(name="dataAccessService", initMethod="init", destroyMethod="destroy")
	public DataAccessService getDataAccessService() {
		return new DataAccessService();
	}

}
