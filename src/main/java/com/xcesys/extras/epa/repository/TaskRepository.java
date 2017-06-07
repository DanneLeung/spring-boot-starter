package com.xcesys.extras.epa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xcesys.extras.epa.entity.Task;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface TaskRepository extends IBaseRepository<Task, Long> {

	@Query("select c from #{#entityName} c where worker = :worker and status=:status and receiveStartTime<=:date and receiveEndTime>:date")
	List<Task> findByWorker(@Param("worker") Long worker, @Param("status") String status, @Param("date") String date);

	@Modifying
	@Query("update #{#entityName} set status = '3' , receiveTime= :receiveTime where worker = :userId and id in (:ids)")
	int claim(@Param("userId") Long userId, @Param("ids") List<Long> ids,@Param("receiveTime")Date receiveTime);

	@Modifying
	@Query("update #{#entityName} set status = '4', commitTime = :commitTime where worker = :userId and id in (:ids)")
	int finish(@Param("userId") Long userId, @Param("ids") List<Long> ids, @Param("commitTime") Date commitTime);

}
