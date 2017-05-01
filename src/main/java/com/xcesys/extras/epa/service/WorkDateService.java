package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.WorkDate;
import com.xcesys.extras.epa.repository.WorkDateRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class WorkDateService extends BaseCrudService<WorkDate, Long> {
	@Autowired
	private WorkDateRepository repository;

	@Override
	public IBaseRepository<WorkDate, Long> getRepository() {
		return repository;
	}

}
