package com.xcesys.extras.repository;

import com.xcesys.extras.entity.User;
import com.xcesys.extras.framework.repository.IBaseRepository;

public interface UserRepository extends IBaseRepository<User, Long> {

	User findByIdNotAndUsername(Long id, String username);

	User findByUsername(String username);
	
	int countByUsername(String username);
}
