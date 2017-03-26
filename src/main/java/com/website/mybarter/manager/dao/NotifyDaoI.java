package com.website.mybarter.manager.dao;

import java.util.List;

import com.website.mybarter.manager.model.Tnotify;

public interface NotifyDaoI extends BaseDaoI<Tnotify> {

	/** 
	 * 插入通知
	 * @author 王鹏  
	 * @日期 2014年9月29日
	 * @param notify
	 */
	public void add(Tnotify notify);
	
	/**
	 * 
	 * 查询通知
	 * @author 王鹏  
	 * @日期 2015年2月15日
	 * @param notify
	 * @return
	 */
	public Tnotify get(Tnotify whereParam);
	
	/**
	 * 
	 * 查询全部通知
	 * @author 王鹏  
	 * @日期 2015年11月23日
	 * @return
	 */
	public List<Tnotify> getAll();
}
