package com.xcesys.extras.repository;

import com.xcesys.extras.entity.Role;
import com.xcesys.extras.framework.repository.IBaseRepository;

public interface RoleRepository extends IBaseRepository<Role, Long> {

	Role findByName(String name);

}
