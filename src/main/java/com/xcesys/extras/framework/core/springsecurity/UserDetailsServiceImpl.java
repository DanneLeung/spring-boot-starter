package com.xcesys.extras.framework.core.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.entity.User;
import com.xcesys.extras.framework.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			// log.debug("User with username = \"" + username + "\" was not
			// found");
			throw new UsernameNotFoundException("User with username = \"" + username + "\" was not found");
		}
		return user;
	}
}
