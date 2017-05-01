package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.PartPic;
import com.xcesys.extras.epa.repository.PartPicRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class PartPicService extends BaseCrudService<PartPic, Long> {
	@Autowired
	private PartPicRepository repository;

	@Override
	public IBaseRepository<PartPic, Long> getRepository() {
		return repository;
	}

}
