package com.website.mybarter.manager.dao;

import java.util.List;
import java.util.Map;

import com.website.mybarter.manager.model.Tmenu;

public interface MenuDaoI extends BaseDaoI<Tmenu> {

	public List<Tmenu> getTree();

	public List<Tmenu> getTreeById(Map<String, Object> params);

	public List<Tmenu> getAllTree();
}
