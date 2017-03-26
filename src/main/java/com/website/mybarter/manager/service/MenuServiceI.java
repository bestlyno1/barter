package com.website.mybarter.manager.service;

import java.util.List;

import com.website.mybarter.manager.pagemodel.Menus;

public interface MenuServiceI {

	public List<Menus> getTree(String id);

	public List<Menus> getAllTree();
}
