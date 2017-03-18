package com.xcesys.extras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.entity.User;
import com.xcesys.extras.framework.repository.IBaseRepository;
import com.xcesys.extras.framework.service.impl.BaseCrudService;
import com.xcesys.extras.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserService extends BaseCrudService<User, Long> {
	@Autowired(required = false)
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	private String encryptPassword(String password) {
		return passwordEncoder != null ? passwordEncoder.encode(password) : password;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public IBaseRepository<User, Long> getRepository() {
		return userRepository;
	}

//	public User save(User user) {
//		log.info("Creating {} user", user.getUsername());
//
//		if (user.isNew() && userRepository.countByUsername(user.getUsername()) > 0) {
//			throw new RuntimeException("Cannot create user with username \"" + user.getUsername()
//					+ "\" , the username is already in use by another user.");
//		}
//
//		// Encode password
//		user.setPassword(encryptPassword(user.getPassword()));
//		user.setAccountNonExpired(true);
//		user.setAccountNonLocked(true);
//		user.setCredentialsNonExpired(true);
//
//		// create entity
//		return super.save(user);
//	}

//	public User update(User user) {
//		if (userRepository.findByIdNotAndUsername(user.getId(), user.getUsername()) != null) {
//			throw new RuntimeException("Cannot update user with username  \"" + user.getUsername()
//					+ "\" , the username is already in use by another user.");
//		}
//
//		// save entity
//		return userRepository.save(user);
//	}

	public int countByUsername(String username) {
		return userRepository.countByUsername(username);
	}
}
