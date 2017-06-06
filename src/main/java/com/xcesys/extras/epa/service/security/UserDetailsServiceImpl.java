package com.xcesys.extras.epa.service.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.epa.repository.UserRepository;
import com.xcesys.extras.framework.core.security.JwtUserFactory;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
		
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			return JwtUserFactory.create(user.getId(), user.getUsername(), user.getPassword(), Collections.emptyList(),
					!user.getDeleted(), user);
		}
	}
}
