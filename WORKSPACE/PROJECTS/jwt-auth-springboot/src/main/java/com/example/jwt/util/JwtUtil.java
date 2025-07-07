package com.example.jwt.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.example.jwt.model.AuthRequest;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

	SecretKey key = Jwts.SIG.HS256.key().build();

	public String generateToken(AuthRequest authRequest) {
		return Jwts.builder().subject(authRequest.getUsername()).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 6 * 5)).signWith(key).compact();
	}

	public String extractUsername(String token) {
		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
	}

	public boolean validateToken(String token, String username) {
		return extractUsername(token).equals(username) && !isTokenExpired(token);

	}

	private boolean isTokenExpired(String token) {
		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getExpiration()
				.before(new Date());
	}
}