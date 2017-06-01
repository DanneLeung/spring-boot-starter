package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.epa.repository.TaskRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class TaskService extends BaseCrudService<Task, Long> {
	@Autowired
	private TaskRepository repository;

	@Override
	public IBaseRepository<Task, Long> getRepository() {
		return repository;
	}

	public Iterable<Task> findByWorker(Long id) {
		return repository.findByWorkerAndStatus(id, "2");
	}

	public int claim(Long userId, Long[] ids) {
		return repository.claim(userId, ids);
	}

	public int finish(Long userId, Long[] ids) {
		return repository.finish(userId, ids);
	}

}
