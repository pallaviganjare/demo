package com.taskTracker.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.taskTracker.filter.JwtAuthenticationFilter;

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
		http=http.cors().and().csrf().disable();
		http=http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		http.authorizeRequests().antMatchers("/api/admin/*").hasRole("ADMIN")
								.antMatchers("/api/user/*").hasAnyRole("ADMIN","USER")
								.antMatchers("/api/public/*").permitAll();
		
		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("HEAD","GET", "POST", "PUT", "DELETE", "PATCH"));
		//config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		 source.registerCorsConfiguration("/**", config);
		 return source;
	}

}
