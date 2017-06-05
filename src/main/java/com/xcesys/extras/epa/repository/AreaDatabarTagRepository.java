package com.xcesys.extras.epa.repository;

import java.util.List;

import com.xcesys.extras.epa.entity.AreaDatabarTag;
import com.xcesys.extras.framework.core.repository.IBaseRepository;

public interface AreaDatabarTagRepository extends IBaseRepository<AreaDatabarTag, Long> {
	List<AreaDatabarTag> findByAreaAndDatabarOrderByOrders(Long area, Long databar);
}
