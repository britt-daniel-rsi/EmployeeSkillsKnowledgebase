package com.rsi.esk.dao;

import java.util.List;

public interface BaseDao<T> {
	Long getNextId();

	void saveOrUpdate(T entity);

	List<T> list();

	T findById(Long id);
}
