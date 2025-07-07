package com.example.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.model.AuthRequest;
import com.example.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
//		if (authentication.isAuthenticated()) {
//			return jwtUtil.generateToken(authRequest);
//		} else {
//			throw new UsernameNotFoundException("Invalid user request!");
//		}
		return jwtUtil.generateToken(authRequest);
	}

	@PostMapping("/hello")
	public AuthRequest hello(@RequestBody AuthRequest authRequest) {
		return authRequest;
	}

}
