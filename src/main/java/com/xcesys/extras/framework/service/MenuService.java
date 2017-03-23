package com.xcesys.extras.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.impl.BaseCrudService;
import com.xcesys.extras.framework.entity.Menu;
import com.xcesys.extras.framework.repository.MenuRepository;

@Service
@Transactional
public class MenuService extends BaseCrudService<Menu, Long> {
	@Autowired
	private MenuRepository repository;

	public Menu findByName(String name) {
		return repository.findByName(name);
	}

	public Iterable<Menu> findByParentId(Long parentId) {
		return repository.findByParentId(parentId);
	}

	@Override
	public IBaseRepository<Menu, Long> getRepository() {
		return repository;
	}

	public long countByName(String name) {
		return repository.countByName(name);
	}
}
