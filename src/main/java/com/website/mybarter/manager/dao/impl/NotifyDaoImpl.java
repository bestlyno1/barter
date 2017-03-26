package com.website.mybarter.manager.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.website.mybarter.manager.dao.NotifyDaoI;
import com.website.mybarter.manager.model.Tnotify;

@Repository("notifyDao")
public class NotifyDaoImpl extends BaseDaoImpl<Tnotify> implements NotifyDaoI {

	/**
	 * 插入通知
	 * 
	 * @author 王鹏
	 * @日期 2014年9月29日
	 * @param notify
	 */
	@Override
	public void add(Tnotify notify) {
		super.save(notify);
	}

	/**
	 * 
	 * 查询通知
	 * 
	 * @author 王鹏
	 * @日期 2015年2月15日
	 * @param notify
	 * @return
	 */
	@Override
	public Tnotify get(Tnotify whereParam) {
		Tnotify notify = new Tnotify();
		String hql = "from Tnotify where title like :title";
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("title", "%" + whereParam.getTitle() + "%");
		notify = super.get(hql, where);
		return notify;
	}

	@Override
	public List<Tnotify> getAll() {
		List<Tnotify> notifyList = new ArrayList<Tnotify>();
		
		notifyList = super.find("from Tnotify");
		
		return notifyList;
	}

}
