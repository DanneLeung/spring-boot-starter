package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.AppToken;
import com.xcesys.extras.epa.repository.AppTokenRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class AppTokenService extends BaseCrudService<AppToken, Long> {
	@Autowired
	private AppTokenRepository repository;

	@Override
	public IBaseRepository<AppToken, Long> getRepository() {
		return repository;
	}

}
