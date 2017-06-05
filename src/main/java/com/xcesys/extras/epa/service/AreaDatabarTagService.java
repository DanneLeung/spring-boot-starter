package com.xcesys.extras.epa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.AreaDatabarTag;
import com.xcesys.extras.epa.repository.AreaDatabarTagRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class AreaDatabarTagService extends BaseCrudService<AreaDatabarTag, Long> {
	@Autowired
	private AreaDatabarTagRepository repository;

	@Override
	public IBaseRepository<AreaDatabarTag, Long> getRepository() {
		return repository;
	}

	public List<AreaDatabarTag> findByAreaAndDatabar(Long area, Long databar) {
		return repository.findByAreaAndDatabarOrderByOrders(area, databar);
	}

}
