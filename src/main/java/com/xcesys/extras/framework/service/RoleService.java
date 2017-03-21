package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.Role;
import com.xcesys.extras.framework.repository.RoleRepository;

@Service
@Transactional
public class RoleService extends BaseCrudService<Role, Long> {
	@Autowired
	private RoleRepository repository;

	public Role findByName(String Rolename) {
		return repository.findByName(Rolename);
	}

	@Override
	public IBaseRepository<Role, Long> getRepository() {
		return repository;
	}

	public int countByName(String name) {
		return repository.countByName(name);
	}

	public Role usersInRole(Long id) {
		return repository.findUsersById(id);
	}
}
