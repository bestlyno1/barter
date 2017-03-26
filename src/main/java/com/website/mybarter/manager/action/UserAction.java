package com.website.mybarter.manager.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.website.mybarter.manager.pagemodel.Json;
import com.website.mybarter.manager.pagemodel.User;
import com.website.mybarter.manager.service.UserServiceI;

@Action("userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

	private UserServiceI userService;
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	/**
	 * 用户注册
	 */
	public void addUser() {
		Json j = new Json();

		try {
			userService.addUser(user);
			j.setSuccess(true);
			j.setMsg("注册成功！");
		} catch (Exception e) {
			j.setMsg("注册失败！");
		}

		super.writeJson(j);
	}

	/**
	 * 用户登录
	 */
	public void login() {
		Json j = new Json();
		User rtnUser = userService.login(user);
		if (rtnUser != null) {
			j.setSuccess(true);
			j.setMsg("登录成功！");
		} else {
			j.setMsg("登录失败！");
		}

		super.writeJson(j);
	}

	/**
	 * 取得用户列表
	 * 
	 * @author 王鹏
	 * @日期 2014年9月7日
	 */
	public void getUserList() {
		super.writeJson(userService.getUserList(user));
	}
}
