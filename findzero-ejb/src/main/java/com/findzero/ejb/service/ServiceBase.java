package com.findzero.ejb.service;

import java.util.List;

public interface ServiceBase<T> {
	public void add(T entity) throws Exception;
	public void alter(T entity)throws Exception;
	public void remove(T entity) throws Exception;
	public T findByPk(Long id)throws Exception;
	public List<T> listAll() throws Exception;
}
