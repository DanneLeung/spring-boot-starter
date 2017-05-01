package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.Area;
import com.xcesys.extras.epa.repository.AreaRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class AreaService extends BaseCrudService<Area, Long> {
	@Autowired
	private AreaRepository repository;

	@Override
	public IBaseRepository<Area, Long> getRepository() {
		return repository;
	}

}
