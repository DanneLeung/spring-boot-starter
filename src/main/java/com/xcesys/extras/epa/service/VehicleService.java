package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.Vehicle;
import com.xcesys.extras.epa.repository.VehicleRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class VehicleService extends BaseCrudService<Vehicle, Long> {
	@Autowired
	private VehicleRepository repository;

	@Override
	public IBaseRepository<Vehicle, Long> getRepository() {
		return repository;
	}

}
