package com.xcesys.extras.framework.repository;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.entity.Role;

public interface RoleRepository extends IBaseRepository<Role, Long> {

	Role findByName(String name);

	long countByName(String name);

	Role findUsersById(Long id);
}
