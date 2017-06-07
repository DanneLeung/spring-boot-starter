package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.Apk;
import com.xcesys.extras.epa.repository.ApkRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class ApkService extends BaseCrudService<Apk, Long> {
	@Autowired
	private ApkRepository repository;

	@Override
	public IBaseRepository<Apk, Long> getRepository() {
		return repository;
	}

}
