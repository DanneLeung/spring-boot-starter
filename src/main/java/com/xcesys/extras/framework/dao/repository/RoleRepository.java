package com.xcesys.extras.framework.dao.repository;

import com.xcesys.extras.framework.entity.Role;

public interface RoleRepository extends IBaseRepository<Role, Long> {

	Role findByName(String name);

	int countByName(String name);

	Role findUsersById(Long id);
}
