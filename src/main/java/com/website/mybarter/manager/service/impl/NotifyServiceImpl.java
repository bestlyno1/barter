package com.website.mybarter.manager.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.mybarter.manager.dao.NotifyDaoI;
import com.website.mybarter.manager.model.Tnotify;
import com.website.mybarter.manager.pagemodel.DataGrid;
import com.website.mybarter.manager.pagemodel.Notify;
import com.website.mybarter.manager.service.NotifyServiceI;

@Service("notifyService")
public class NotifyServiceImpl implements NotifyServiceI {

	NotifyDaoI notifyDao;

	public NotifyDaoI getNotifyDao() {
		return notifyDao;
	}

	@Autowired
	public void setNotifyDao(NotifyDaoI notifyDao) {
		this.notifyDao = notifyDao;
	}

	/**
	 * 插入通知Service
	 * 
	 * @author 王鹏
	 * @日期 2014年9月29日
	 * @param notify
	 */
	@Override
	public void add(Notify notify) throws ParseException {
		Tnotify tNotify = new Tnotify();
		BeanUtils.copyProperties(notify, tNotify);
		// ID
		tNotify.setId(UUID.randomUUID().toString());
		// 发布时间
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dt = format.parse(notify.getReleasetime());
		tNotify.setReleasetime(dt);
		// 是否邮件通知
		if ("on".equals(notify.getSendmail())) {
			tNotify.setSendmail("1");
		} else {
			tNotify.setSendmail("0");
		}
		notifyDao.add(tNotify);
	}

	/**
	 * 
	 * 查询详细通知
	 * 
	 * @author 王鹏
	 * @日期 2015年2月15日
	 * @param where
	 * @return
	 */
	@Override
	public Notify getNotify(Notify where) {
		Tnotify tNotify = new Tnotify();
		Notify notify = new Notify();
		BeanUtils.copyProperties(where, tNotify);
		tNotify = notifyDao.get(tNotify);

		BeanUtils.copyProperties(tNotify, notify);
		return notify;
	}

	/**
	 * 
	 * 查询全部通知
	 * 
	 * @author 王鹏
	 * @日期 2015年11月23日
	 * @return
	 */
	@Override
	public DataGrid getAll(Notify notify) {
		List<Notify> notifyList = new ArrayList<Notify>();
		// 通知取得
		List<Tnotify> tnotifyList = notifyDao.find("from Tnotify t",
				new HashMap<String, Object>(),
				notify.getPages(), 
				notify.getRows());
		
		// 总件数
		String totalHql = "select count(*) from Tnotify t";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		// 表示model转换
		for(Tnotify ttmp : tnotifyList){
			Notify n = new Notify();
			BeanUtils.copyProperties(ttmp, n);
			n.setReleasetime(sf.format(ttmp.getReleasetime()));
			notifyList.add(n);
		}
		
		// 画面用json
		DataGrid gd = new DataGrid();
		gd.setTotal(notifyDao.count(totalHql));
		gd.setRows(notifyList);
		
		return gd;
	}
}
