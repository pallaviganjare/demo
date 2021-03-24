package com.taskTracker.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.taskTracker.model.user.User;
import com.taskTracker.util.JWTUtil;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header == null || !header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		final String token = header.split(" ")[1].trim();
		User user = jwtUtil.parseToken(token);
		if (user == null) {
			filterChain.doFilter(request, response);
			return;
		}
		List<GrantedAuthority> roleList = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user.getFirstName(),null, roleList);
		SecurityContextHolder.getContext().setAuthentication(userToken);
		filterChain.doFilter(request, response);
	}

}
