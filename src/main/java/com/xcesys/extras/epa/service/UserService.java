package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.User;
import com.xcesys.extras.epa.repository.UserRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class UserService extends BaseCrudService<User, Long> {
	// @Autowired(r/*equired = false)
	// private P*/asswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;

	private String encryptPassword(String password) {
		// return passwordEncoder != null ? passwordEncoder.encode(password) :
		// password;
		return password;
	}

	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public IBaseRepository<User, Long> getRepository() {
		return repository;
	}

	public int resetpwd(Long[] ids) {
		return repository.resetpwd(ids, encryptPassword("123456"));
	}

	public long countByUsername(String username) {
		return repository.countByUsername(username);
	}
}
