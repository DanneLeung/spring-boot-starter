package com.xcesys.extras.framework.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.xcesys.extras.framework.entity.IdEntity;
import com.xcesys.extras.framework.repository.IBaseRepository;

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
public interface ICrudService<T extends IdEntity, ID extends Serializable> {
	/**
	 * <p>
	 * Creates a collection of data object.
	 * 
	 * @param objects
	 *            a collection of objects to be created.
	 * @return a collection of objects just created.
	 */
	public Collection<T> create(Collection<T> o_list);

	/**
	 * <p>
	 * Deletes a collection of data objects, if object is an instance of
	 * {@link IDeleteable}, logical deletion (deleted=true) used instead.
	 * 
	 * @param objects
	 *            an collection of objects to be deleted.
	 */
	public void delete(Collection<T> o_list);

	/**
	 * <p>
	 * Deletes single data object identified by id, if object is an instance of
	 * {@link IDeleteable}, logical deletion (deleted=true) used instead.
	 * 
	 * @param id
	 *            id of object to be deleted.
	 */
	public void delete(ID id);

	public void delete(ID[] ids);

	/**
	 * <p>
	 * Deletes single data object, if object is an instance of
	 * {@link IDeleteable}, logical deletion (deleted=true) used instead.
	 * 
	 * @param object
	 *            object to be deleted.
	 */
	public void delete(T o);

	/**
	 * 启用或禁用数据，对象中enabled属性将被更新。
	 * 
	 * @param ids
	 *            将被更新的对象id数组
	 * @param enabled
	 *            true为启用，false为禁用
	 */
	public int enabled(boolean enabled, Long... ids);

	/**
	 * <p>
	 * Returns all objects.
	 * 
	 * @return all data objects.
	 */
	public Iterable<T> findAll();

	public DataTablesOutput<T> findAll(DataTablesInput input);

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
	public T findById(ID id);

	/**
	 * <p>
	 * Finds and returns a collection of data objects with specified an array of
	 * ids.
	 * 
	 * @param ids
	 *            an array of primary ids of data object.
	 * @return a list of data object, null if not found.
	 */
	public List<T> findByIds(Long[] ids);

	/**
	 * <p>
	 * Finds and returns single data object identified by id.
	 * 
	 * @param id
	 *            primary id of data object.
	 * @return data object, null if not found.
	 */
	public T getById(ID id);

	/**
	 * Return the Dao bean.
	 * 
	 * @return instance of {@link IDao}.
	 */
	public IBaseRepository<T, ID> getRepository();

	/**
	 * <p>
	 * Creates a single data object.
	 * 
	 * @param object
	 *            an object to be created.
	 * @return an object just created.
	 */
	public T save(T o);

	/**
	 * <p>
	 * Updates single data object.
	 * 
	 * @param object
	 *            object to be updated.
	 * @return T
	 */
	public T update(T o);
}
