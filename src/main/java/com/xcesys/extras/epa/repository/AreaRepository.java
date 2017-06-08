package com.xcesys.extras.epa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.xcesys.extras.epa.entity.Area;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface AreaRepository extends IBaseRepository<Area, Long> {

	@Query("select c from #{#entityName} c join fetch c.databars b join fetch b.tags ")
	public List<Area> findAllById();

}
