package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.User;
import com.xcesys.extras.framework.repository.UserRepository;

@Service
@Transactional
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
