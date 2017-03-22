package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.DictType;
import com.xcesys.extras.framework.repository.DictTypeRepository;

@Service
@Transactional
public class DictTypeService extends BaseCrudService<DictType, Long> {
	@Autowired
	private DictTypeRepository reposity;

	public DictType findByName(String DictTypename) {
		return reposity.findByName(DictTypename);
	}

	@Override
	public IBaseRepository<DictType, Long> getRepository() {
		return reposity;
	}

	public long countByName(String name) {
		return reposity.countByName(name);
	}

}
