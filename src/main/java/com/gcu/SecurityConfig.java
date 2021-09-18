package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gcu.service.BusinessService;

@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BusinessService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//String encoded = new BCryptPasswordEncoder().encode("test");
		//System.out.println("password: " + encoded);
		http.csrf()
			.disable()
			.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/service/**").authenticated()
				.and()
			.authorizeRequests()
				.antMatchers("/","/images/**","/css/**","/register/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/loggedIn", true)
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/");
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
	}
}
