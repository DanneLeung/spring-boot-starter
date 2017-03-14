package com.xcesys.extras.framework.service;

public interface IInterfaceService<T> {

	/**
	 * Processes interface data.
	 * 
	 * @param data
	 *            data.
	 * @return
	 */
	public abstract T processData(T data);

}