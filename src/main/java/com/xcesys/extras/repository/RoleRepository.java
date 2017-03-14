package com.xcesys.extras.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.xcesys.extras.entity.Role;

public interface RoleRepository extends DataTablesRepository<Role, Long> {

	Role findByName(String name);

}
