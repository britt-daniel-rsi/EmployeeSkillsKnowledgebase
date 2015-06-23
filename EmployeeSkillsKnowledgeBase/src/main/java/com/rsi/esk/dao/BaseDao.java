package com.rsi.esk.dao;

import java.util.List;

import org.dom4j.tree.AbstractEntity;

public interface BaseDao<T extends AbstractEntity> {
	Long getNextId();

	void saveOrUpdate(T entity);

	List<T> list();

	T findById(Long id);
}
