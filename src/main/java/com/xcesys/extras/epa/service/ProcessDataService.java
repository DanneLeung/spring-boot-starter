package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.ProcessData;
import com.xcesys.extras.epa.repository.ProcessDataRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class ProcessDataService extends BaseCrudService<ProcessData, Long> {
	@Autowired
	private ProcessDataRepository repository;

	@Override
	public IBaseRepository<ProcessData, Long> getRepository() {	
		return repository;
	}

}
