package com.xcesys.extras.framework.repository;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.entity.DictType;

public interface DictTypeRepository extends IBaseRepository<DictType, Long> {

	DictType findByName(String name);

	int countByName(String name);
}
