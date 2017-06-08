package com.xcesys.extras.epa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface DataBarRepository extends IBaseRepository<DataBar, Long> {

	@Query("select c from #{#entityName} c join fetch c.tags where c.type=:type ")
	List<DataBar> findByType(@Param("type") String type);
}
