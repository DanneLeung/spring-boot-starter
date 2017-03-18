package com.xcesys.extras.framework.repository;

import java.io.Serializable;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends DataTablesRepository<T, ID>, JpaRepository<T, ID> {

}
