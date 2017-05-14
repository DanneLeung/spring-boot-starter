package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.DictType;
import com.xcesys.extras.epa.repository.DictRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class DictService extends BaseCrudService<DictType, Long> {
	@Autowired
	private DictRepository repository;

	@Override
	public IBaseRepository<DictType, Long> getRepository() {
		return repository;
	}

}
