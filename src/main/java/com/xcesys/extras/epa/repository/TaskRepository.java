package com.xcesys.extras.epa.repository;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface TaskRepository extends IBaseRepository<Task, Long> {

	Iterable<Task> findByWorker(Long id);

}
