package com.website.mybarter.manager.service;

import java.text.ParseException;

import com.website.mybarter.manager.pagemodel.DataGrid;
import com.website.mybarter.manager.pagemodel.Notify;

public interface NotifyServiceI {

	/**
	 * 插入通知Service
	 * 
	 * @author 王鹏
	 * @日期 2014年9月29日
	 * @param notify
	 * @throws java.text.ParseException
	 */
	public void add(Notify notify) throws ParseException;
	
	/**
	 * 
	 * 查询详细通知
	 * @author 王鹏  
	 * @日期 2015年2月15日
	 * @return
	 */
	public Notify getNotify(Notify notify);
	
	/**
	 * 
	 * 查询全部通知
	 * @author 王鹏  
	 * @日期 2015年11月23日
	 * @return
	 */
	public DataGrid getAll(Notify notify);
}
