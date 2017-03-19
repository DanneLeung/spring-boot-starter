package com.xcesys.extras.framework.dao.repository;

import java.io.Serializable;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends DataTablesRepository<T, ID>, JpaRepository<T, ID> {
	@Modifying
	@Query("update #{#entityName} set enabled = :enabled where id in :ids")
	int enable(@Param("enabled") boolean enabled, @Param("ids") ID[] ids);
}
