package com.website.mybarter.manager.service;

import java.io.Serializable;

import com.website.mybarter.manager.pagemodel.DataGrid;
import com.website.mybarter.manager.pagemodel.User;

public interface UserServiceI
{
	public Serializable addUser(User user);
	
	public User login(User user);
	
	public DataGrid getUserList(User parUser);
}
