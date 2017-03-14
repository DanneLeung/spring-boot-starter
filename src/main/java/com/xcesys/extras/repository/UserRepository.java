package com.xcesys.extras.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.xcesys.extras.entity.User;

public interface UserRepository extends DataTablesRepository<User, Long> {

	User findByUsername(String username);

	User findByIdNotAndUsername(Long id, String username);
}
