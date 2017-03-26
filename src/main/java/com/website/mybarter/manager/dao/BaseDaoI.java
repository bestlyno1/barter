package com.website.mybarter.manager.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDaoI<T> {

	/**
	 * 追加
	 * 
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * 返回符合条件的记录
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public T get(String hql, Map<String, Object> params);

	/**
	 * 删除
	 * 
	 * @param o
	 */
	public void delete(T o);

	/**
	 * 更新
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * 追加或更新
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);

	/**
	 * 返回所有结果集
	 * 
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);

	/**
	 * 返回符合条件的结果集
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params);

	/**
	 * 无条件分页
	 * 
	 * @param hql
	 * @param pages
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, int pages, int rows);

	/**
	 * 有条件分页
	 * 
	 * @param hql
	 * @param params
	 * @param pages
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, Map<String, Object> params, int pages, int rows);

	/**
	 * 总记录数
	 * 
	 * @param sql
	 * @return
	 */
	public Long count(String sql);

	/**
	 * 有条件总记录数
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Long count(String sql, Map<String, Object> params);
}
