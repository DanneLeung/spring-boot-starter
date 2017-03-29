package com.xcesys.extras.framework.core.service;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.xcesys.extras.framework.core.repository.IBaseRepository;

/**
 * <p>
 * Crud service interface defines a series of convenient methods for business
 * logic operation.
 * <p>
 * 
 * @author Danne Leung
 * @param <T>
 *            parameterized class.
 */
public interface ICrudService<T, ID extends Serializable> {
	/**
	 * <p>
	 * Creates a collection of data object.
	 * 
	 * @param objects
	 *            a collection of objects to be created.
	 * @return a collection of objects just created.
	 */
	Iterable<T> create(Iterable<T> o_list);

	/**
	 * <p>
	 * Deletes a collection of data objects, if object is an instance of
	 * {@link IDeleteable}, logical deletion (deleted=true) used instead.
	 * 
	 * @param objects
	 *            an collection of objects to be deleted.
	 */
	void delete(Iterable<T> o_list);

	/**
	 * <p>
	 * Deletes single data object identified by id, if object is an instance of
	 * {@link IDeleteable}, logical deletion (deleted=true) used instead.
	 * 
	 * @param id
	 *            id of object to be deleted.
	 */
	void delete(ID id);

	void delete(ID[] ids);

	/**
	 * <p>
	 * Deletes single data object, if object is an instance of
	 * {@link IDeleteable}, logical deletion (deleted=true) used instead.
	 * 
	 * @param object
	 *            object to be deleted.
	 */
	void delete(T o);

	/**
	 * 启用或禁用数据，对象中enabled属性将被更新。
	 * 
	 * @param ids
	 *            将被更新的对象id数组
	 * @param enabled
	 *            true为启用，false为禁用
	 */
	int enable(boolean enabled, ID[] ids);

	boolean exists(ID id);

	/**
	 * <p>
	 * Returns all objects.
	 * 
	 * @return all data objects.
	 */
	Iterable<T> findAll();

	DataTablesOutput<T> findAll(DataTablesInput input);

	/**
	 * <p>
	 * Finds and returns single data object identified by id.
	 * <p>
	 * <b>Notes:<b> Exception throws while specified object not found.
	 * 
	 * @param id
	 *            primary id of data object.
	 * @return data object.
	 */
	T findById(ID id);

	/**
	 * <p>
	 * Finds and returns a collection of data objects with specified an array of
	 * ids.
	 * 
	 * @param ids
	 *            an array of primary ids of data object.
	 * @return a list of data object, null if not found.
	 */
	Iterable<T> findByIds(ID[] ids);

	/**
	 * <p>
	 * Finds and returns single data object identified by id.
	 * 
	 * @param id
	 *            primary id of data object.
	 * @return data object, null if not found.
	 */
	T getById(ID id);

	/**
	 * Return the Dao bean.
	 * 
	 * @return instance of {@link IDao}.
	 */
	IBaseRepository<T, ID> getRepository();

	/**
	 * <p>
	 * Creates a single data object.
	 * 
	 * @param object
	 *            an object to be created.
	 * @return an object just created.
	 */
	T save(T o);

	/**
	 * <p>
	 * Updates single data object.
	 * 
	 * @param object
	 *            object to be updated.
	 * @return T
	 */
	T update(T o);
	
	Page<T> findAll(Pageable pageable);
}
