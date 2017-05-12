package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.TaskPlan;
import com.xcesys.extras.epa.repository.TaskPlanRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class TaskPlanService extends BaseCrudService<TaskPlan, Long> {
	@Autowired
	private TaskPlanRepository repository;

	@Override
	public IBaseRepository<TaskPlan, Long> getRepository() {	
		return repository;
	}

	public Iterable<TaskPlan> findByWorker(Long id) {
		return repository.findByWorker(id);
	}

}
