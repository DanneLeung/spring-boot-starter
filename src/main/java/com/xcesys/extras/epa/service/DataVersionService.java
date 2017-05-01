package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.DataVersion;
import com.xcesys.extras.epa.repository.DataVersionRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class DataVersionService extends BaseCrudService<DataVersion, Long> {
	@Autowired
	private DataVersionRepository repository;

	@Override
	public IBaseRepository<DataVersion, Long> getRepository() {	
		return repository;
	}

}
