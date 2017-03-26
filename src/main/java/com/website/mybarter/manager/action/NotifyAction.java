package com.website.mybarter.manager.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.website.mybarter.manager.pagemodel.Json;
import com.website.mybarter.manager.pagemodel.Notify;
import com.website.mybarter.manager.service.NotifyServiceI;

@Action("notifyAction")
public class NotifyAction extends BaseAction implements ModelDriven<Notify> {

	Notify notify = new Notify();
	NotifyServiceI notifyService;

	@Override
	public Notify getModel() {
		return notify;
	}

	public NotifyServiceI getNotifyService() {
		return notifyService;
	}

	@Autowired
	public void setNotifyService(NotifyServiceI notifyService) {
		this.notifyService = notifyService;
	}

	public void addNotify() {

		Json j = new Json();
		try {
			notifyService.add(notify);
			j.setSuccess(true);
			j.setMsg("通知登录成功！！");
			
			//test
			notifyService.getNotify(notify);
			//test
		} catch (Exception e) {
			j.setMsg("通知登录失败！！");
		}
		
		super.writeJson(j);
	}
	
	public void getNotify(){
		notify.setPages(1);
		notify.setRows(10);
		
		super.writeJson(notifyService.getAll(notify));
		
	}
}
