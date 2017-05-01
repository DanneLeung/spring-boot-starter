package com.xcesys.extras.epa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.epa.entity.Tag;
import com.xcesys.extras.epa.repository.TagRepository;
import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;

@Service
@Transactional
public class TagService extends BaseCrudService<Tag, Long> {
	@Autowired
	private TagRepository repository;

	@Override
	public IBaseRepository<Tag, Long> getRepository() {
		return repository;
	}

}
