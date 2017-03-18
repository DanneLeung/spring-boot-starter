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

	public int resetpwd(Long[] ids) {
		return userRepository.resetpwd(ids, encryptPassword("123456"));
	}

	public int countByUsername(String username) {
		return userRepository.countByUsername(username);
	}
}
