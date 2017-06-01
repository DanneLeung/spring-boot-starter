package com.xcesys.extras.framework.core.service.impl;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.ICrudService;

public abstract class BaseCrudService<T, ID extends Serializable> implements ICrudService<T, ID> {

	@Override
	public T create(T o) {
		return getRepository().save(o);
	}

	@Override
	public Iterable<T> create(Iterable<T> o_list) {
		return getRepository().save(o_list);
	}

	@Override
	public void delete(Iterable<T> o_list) {
		getRepository().delete(o_list);

	}

	@Override
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
	@Transactional
	public int enable(boolean enabled, ID[] ids) {
		return getRepository().enable(enabled, ids);
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
	public Iterable<T> findByIds(ID[] ids) {
		return getRepository().findAll(Arrays.asList(ids));
	}

	@Override
	public T getById(ID id) {
		return getRepository().getOne(id);
	}

	@Override
	public abstract IBaseRepository<T, ID> getRepository();

	@Override
	public T save(T o) {
		return getRepository().save(o);
	}

	@Override
	public T update(T o) {
		return getRepository().save(o);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

}
