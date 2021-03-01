package com.taskTracker.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter)
	{
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http=http.cors().disable().csrf().disable();
		http=http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		http.authorizeRequests().antMatchers("/api/admin/*").hasRole("ADMIN")
								.antMatchers("/api/user/*").hasAnyRole("ADMIN","USER")
								.antMatchers("/api/public/*").permitAll();
		
		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		
	}

}
