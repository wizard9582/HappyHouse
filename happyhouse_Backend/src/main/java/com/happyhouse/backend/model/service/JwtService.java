package com.happyhouse.backend.model.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.happyhouse.backend.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
	
	@Value("${jwt.salt}")
	private String salt;
	
	@Value("${jwt.expmin}")
	private String expireMin;
	
	
	public String create(final User user) {
		final JwtBuilder builder = Jwts.builder();
		builder.setHeaderParam("typ", "JWT");
		builder.setSubject("loginToken")
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * Integer.parseInt(expireMin)))
		.claim("User", user);
		
		builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());
		final String jwt = builder.compact();
		
		return jwt;
	}
	
	public void checkValid(final String jwt) {
		Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
	}
	
	public Map<String, Object> get(final String jwt) {
		Jws<Claims> claims = null;
		
		try {
			claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
			
		}catch (final Exception e){
			throw new RuntimeException();
		}
		
		return claims.getBody();
	}
}
