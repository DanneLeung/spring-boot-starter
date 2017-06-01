package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.PartPicDetail;
import com.xcesys.extras.epa.repository.PartPicDetailRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class PartPicDetailService extends BaseCrudService<PartPicDetail, Long> {
	@Autowired
	private PartPicDetailRepository repository;

	@Override
	public IBaseRepository<PartPicDetail, Long> getRepository() {
		return repository;
	}

}
