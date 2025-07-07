package com.example.jwt;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		String username = "PANKAJ";
		String password = "PANKAJ#password1234";

//		// Create a BCryptPasswordEncoder instance
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//		// Hash the password
//		String hashedPassword = passwordEncoder.encode(password);
//
//		System.out.println("Original password: " + password);
//		System.out.println("Hashed password: " + hashedPassword);
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
		System.out.println(auth.isAuthenticated());
	}

}
