package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.TaskData;
import com.xcesys.extras.epa.repository.TaskDataRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class TaskDataService extends BaseCrudService<TaskData, Long> {
	@Autowired
	private TaskDataRepository repository;

	@Override
	public IBaseRepository<TaskData, Long> getRepository() {
		return repository;
	}

}
