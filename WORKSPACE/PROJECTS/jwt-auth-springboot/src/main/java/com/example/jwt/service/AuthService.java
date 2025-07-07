package com.example.jwt.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new UserDetails() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return "PANKAJ";
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return "$2a$12$B8FBibh.gOoN89MHwcSx7O1YGdImyrHISjGvs6P1c6Q0TLea2mtLS";
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return Collections.emptyList();
			}
		};
	}

}
