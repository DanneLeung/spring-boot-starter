package com.xcesys.extras.framework.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.entity.User;

public interface UserRepository extends IBaseRepository<User, Long> {

	User findByIdNotAndUsername(Long id, String username);

	User findByUsername(String username);

	long countByUsername(String username);

	@Modifying
	@Query("update #{#entityName} set password = :password where id in :ids")
	int resetpwd(@Param("ids") Long[] ids, @Param("password") String password);
}
