package com.codewithamar.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.codewithamar.blog.entities.User;
import com.codewithamar.blog.exceptions.ResourceNotFoundException;
import com.codewithamar.blog.repositories.UserRepo;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username
				User user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username, 0));
					
				return user;
	}

} 