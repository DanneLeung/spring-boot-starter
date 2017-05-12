package com.xcesys.extras.epa.repository;

import org.springframework.data.jpa.repository.Query;

import com.xcesys.extras.epa.entity.DataVersion;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface DataVersionRepository extends IBaseRepository<DataVersion, Long> {

	@Query("select d.type, max(d.version) as version from DataVersion d group by type")
	Iterable<DataVersion> findMaxVersion();
}
