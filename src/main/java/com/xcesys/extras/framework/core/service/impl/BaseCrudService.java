package com.xcesys.extras.framework.core.service.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.transaction.annotation.Transactional;

import com.xcesys.extras.framework.core.repository.IBaseRepository;
import com.xcesys.extras.framework.core.service.ICrudService;

public abstract class BaseCrudService<T, ID extends Serializable> implements ICrudService<T, ID> {

  @Override
  public Iterable<T> create(Iterable<T> o_list) {
    return getRepository().saveAll(o_list);
  }

  @Override
  public void delete(Iterable<T> o_list) {
    getRepository().deleteAll(o_list);

  }

  public void delete(ID id) {
    getRepository().deleteById(id);
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
    return getRepository().existsById(id);
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
    return this.getRepository().findById(id).orElseThrow(() -> {
      return new NoSuchElementException("id:" + id + " data not found.");
    });
  }

  @Override
  public Iterable<T> findByIds(ID[] ids) {
    return getRepository().findAllById(Arrays.asList(ids));
  }

  @Override
  public T getById(ID id) {
    return getRepository().getOne(id);
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
