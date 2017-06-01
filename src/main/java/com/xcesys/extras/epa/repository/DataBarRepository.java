package com.xcesys.extras.epa.repository;

import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface DataBarRepository extends IBaseRepository<DataBar, Long> {

	Iterable<DataBar> findByType(String type);
}
