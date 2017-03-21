package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.Setting;
import com.xcesys.extras.framework.repository.SettingRepository;

@Service
@Transactional
public class SettingService extends BaseCrudService<Setting, Long> {
	@Autowired
	private SettingRepository repository;

	public Setting findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public IBaseRepository<Setting, Long> getRepository() {
		return repository;
	}

	public int countByName(String name) {
		return repository.countByName(name);
	}

	public Setting usersInSetting(Long id) {
		return repository.findUsersById(id);
	}
}
