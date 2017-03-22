package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.Dict;
import com.xcesys.extras.framework.repository.DictRepository;

@Service
@Transactional
public class DictService extends BaseCrudService<Dict, Long> {
	@Autowired
	private DictRepository reposity;

	public Dict findByName(String Dictname) {
		return reposity.findByName(Dictname);
	}

	@Override
	public IBaseRepository<Dict, Long> getRepository() {
		return reposity;
	}

	public long countByTypeIdAndName(Long typeId, String name) {
		return reposity.countByTypeIdAndName(typeId, name);
	}

	public Iterable<Dict> findByTypeId(@Param("typeId") Long typeId) {
		return reposity.findByTypeId(typeId);
	}

}
