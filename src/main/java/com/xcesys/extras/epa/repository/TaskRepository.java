package com.xcesys.extras.epa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface TaskRepository extends IBaseRepository<Task, Long> {

	Iterable<Task> findByWorkerAndStatus(Long id, String status);

	@Modifying
	@Query("update #{#entityName} set status = '3' where worker = :userId and id in :ids")
	int claim(@Param("userId") Long userId, @Param("ids") Long[] ids);

	@Modifying
	@Query("update #{#entityName} set status = '4' where worker = :userId and id in :ids")
	int finish(@Param("userId") Long userId, @Param("ids") Long[] ids);

}
