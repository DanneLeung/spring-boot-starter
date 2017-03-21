package com.xcesys.extras.framework.repository;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.entity.Dict;

public interface DictRepository extends IBaseRepository<Dict, Long> {

	Dict findByName(String name);

	int countByTypeIdAndName(Long typeId, String name);

	Iterable<Dict> findByTypeId(Long id);
}
