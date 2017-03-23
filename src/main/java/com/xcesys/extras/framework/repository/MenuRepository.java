package com.xcesys.extras.framework.repository;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.entity.Menu;

public interface MenuRepository extends IBaseRepository<Menu, Long> {

	Menu findByName(String name);

	Iterable<Menu> findByParentId(Long parentId);

	long countByName(String name);

	Menu findUsersById(Long id);
}
