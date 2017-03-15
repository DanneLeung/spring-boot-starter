package com.xcesys.extras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.entity.Role;
import com.xcesys.extras.framework.repository.IBaseRepository;
import com.xcesys.extras.framework.service.impl.BaseCrudService;
import com.xcesys.extras.repository.RoleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class RoleService extends BaseCrudService<Role, Long> {
	@Autowired
	private RoleRepository roleRepository;

	public Role findByName(String Rolename) {
		return roleRepository.findByName(Rolename);
	}

	@Override
	public IBaseRepository<Role, Long> getRepository() {
		return roleRepository;
	}
}
