package com.xcesys.extras.service;

import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.entity.User;
import com.xcesys.extras.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class RoleService {
	@Autowired(required = false)
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	public User create(User user) {
		log.info("Creating {} user", user.getUsername());

		if (userRepository.findByUsername(user.getUsername()) != null) {
			throw new RuntimeException("Cannot create user with username  \"" + user.getUsername()
					+ "\" , the username is already in use by another user.");
		}

		// Encode password
		user.setPassword(encryptPassword(user.getPassword()));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		if (user.getAutomaticLogoutTime() == null) {
			user.setAutomaticLogoutTime(Period.hours(1));
		}

		// create entity
		return userRepository.save(user);
	}

	public User update(User user) {
		if (userRepository.findByIdNotAndUsername(user.getId(), user.getUsername()) != null) {
			throw new RuntimeException("Cannot update user with username  \"" + user.getUsername()
					+ "\" , the username is already in use by another user.");
		}

		// save entity
		return userRepository.save(user);
	}

	public void delete(User user) {
		// delete entity
		userRepository.delete(user);
	}

	private String encryptPassword(String password) {
		return passwordEncoder != null ? passwordEncoder.encode(password) : password;
	}

	public DataTablesOutput<User> findAll(DataTablesInput input) {
		return userRepository.findAll(input);
	}
}
