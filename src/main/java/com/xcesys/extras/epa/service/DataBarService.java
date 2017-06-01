package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.epa.repository.DataBarRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class DataBarService extends BaseCrudService<DataBar, Long> {
	@Autowired
	private DataBarRepository repository;

	@Override
	public IBaseRepository<DataBar, Long> getRepository() {	
		return repository;
	}

	public Iterable<DataBar> findByType(String type) {
		return repository.findByType(type);
	}

}
