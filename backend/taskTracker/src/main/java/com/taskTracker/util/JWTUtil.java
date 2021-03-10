package com.taskTracker.util;

import org.springframework.stereotype.Component;

import com.taskTracker.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	final private String secret = "secret";

	final public User parseToken(String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			User user = new User();
			user.setFirstName(body.getSubject());
			user.setRole("ROLE_"+(String) body.get("role"));
			return user;

		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}

	final public String generateToken(User u) {
		Claims claims = Jwts.claims().setSubject(u.getFirstName());
		claims.put("emailId", u.getEmailId());
		claims.put("role", u.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
