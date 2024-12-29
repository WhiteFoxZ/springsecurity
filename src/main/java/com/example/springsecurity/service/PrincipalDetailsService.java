package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService{

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.debug("로그인 시도"+username);
		User user = userRepository.findByUsername(username);
		if(user == null) {
			return null;
		}
		return new PrincipalDetails(user);

	}

}
