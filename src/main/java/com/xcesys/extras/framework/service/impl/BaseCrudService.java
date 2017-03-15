package com.xcesys.extras.framework.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.xcesys.extras.framework.entity.IdEntity;
import com.xcesys.extras.framework.repository.IBaseRepository;
import com.xcesys.extras.framework.service.ICrudService;

public abstract class BaseCrudService<T extends IdEntity, ID extends Serializable> implements ICrudService<T, ID> {

	@Override
	public Collection<T> create(Collection<T> o_list) {
		return null;
	}

	@Override
	public void delete(Collection<T> o_list) {
		getRepository().delete(o_list);

	}

	public void delete(ID id) {
		getRepository().delete(id);
	}

	@Override
	public void delete(ID[] ids) {

	}

	@Override
	public void delete(T o) {
		getRepository().delete(o);

	}

	@Override
	public int enabled(boolean enabled, Long... ids) {

		return 0;
	}

	@Override
	public boolean exists(ID id) {
		return getRepository().exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public DataTablesOutput<T> findAll(DataTablesInput input) {
		return getRepository().findAll(input);
	}

	@Override
	public T findById(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	public List<T> findByIds(Long[] ids) {
		return null;
	}

	@Override
	public T getById(ID id) {
		return getRepository().findOne(id);
	}

	public abstract IBaseRepository<T, ID> getRepository();

	@Override
	public T save(T o) {
		return getRepository().save(o);
	}

	@Override
	public T update(T o) {
		return getRepository().save(o);
	}

}
