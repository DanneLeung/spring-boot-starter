package com.xcesys.extras.epa.repository;

import java.util.List;

import com.xcesys.extras.epa.entity.DataBar;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface DataBarRepository extends IBaseRepository<DataBar, Long> {

	List<DataBar> findByType(String type);
}
