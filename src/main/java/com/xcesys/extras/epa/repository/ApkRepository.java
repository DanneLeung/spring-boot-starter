package com.xcesys.extras.epa.repository;

import org.springframework.data.jpa.repository.Query;

import com.xcesys.extras.epa.entity.Apk;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface ApkRepository extends IBaseRepository<Apk, Long> {

	@Query("select c from #{#entityName} c where c.version = (select max(version) from #{#entityName})")
	Apk findByMaxVersion();

}
