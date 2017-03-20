package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.Setting;
import com.xcesys.extras.framework.repository.SettingRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SettingService extends BaseCrudService<Setting, Long> {
	@Autowired
	private SettingRepository settingRepository;

	public int countByname(String username) {
		return settingRepository.countByName(username);
	}

	public Setting findByName(String name) {
		return settingRepository.findByName(name);
	}

	@Override
	public IBaseRepository<Setting, Long> getRepository() {
		return settingRepository;
	}

	public int countByName(String name) {
		return settingRepository.countByName(name);
	}

	public Setting usersInSetting(Long id) {
		return settingRepository.findUsersById(id);
	}
}
