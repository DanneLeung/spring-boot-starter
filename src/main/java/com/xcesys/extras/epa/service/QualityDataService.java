package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.QualityData;
import com.xcesys.extras.epa.repository.QualityDataRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class QualityDataService extends BaseCrudService<QualityData, Long> {
	@Autowired
	private QualityDataRepository repository;

	@Override
	public IBaseRepository<QualityData, Long> getRepository() {	
		return repository;
	}

}
