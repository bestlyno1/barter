package com.website.mybarter.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.mybarter.manager.dao.MenuDaoI;
import com.website.mybarter.manager.model.Tmenu;
import com.website.mybarter.manager.pagemodel.Menus;
import com.website.mybarter.manager.service.MenuServiceI;

@Service("menuService")
public class MenuServiceImpl implements MenuServiceI {

	private MenuDaoI menuDao;

	public MenuDaoI getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(MenuDaoI menuDao) {
		this.menuDao = menuDao;
	}

	/**
	 * 异步加载数节点
	 * 
	 * @author 王鹏
	 * @日期 2014年9月4日
	 * @param id
	 * @return
	 */
	@Override
	public List<Menus> getTree(String id) {
		// 检索条件
		Map<String, Object> map = new HashMap<String, Object>();

		List<Tmenu> listTmenu;
		if (id == null || "".equals(id)) {
			// ID没有时候，加载全部节点
			listTmenu = menuDao.getTree();
		} else {
			// 有ID的时候，加载节点ID下面的子节点
			map.put("id", id);
			listTmenu = menuDao.getTreeById(map);
		}

		List<Menus> listMenu = new ArrayList<Menus>();
		if (listTmenu != null && listTmenu.size() > 0) {
			for (Tmenu t : listTmenu) {
				Menus m = new Menus();
				// 转换成 page model
				BeanUtils.copyProperties(t, m);

				// 把URL属性加入attributes里
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", t.getUrl());
				m.setAttributes(attributes);

				if (t.getTmenus() != null && !t.getTmenus().isEmpty()) {
					m.setState("closed");
				} else {
					m.setState("open");
				}

				listMenu.add(m);
			}
		}

		return listMenu;
	}

	/**
	 * 加载全部数节点
	 * 
	 * @author 王鹏
	 * @日期 2014年9月4日
	 * @return
	 */
	@Override
	public List<Menus> getAllTree() {
		List<Tmenu> listTmenu = menuDao.getAllTree();
		List<Menus> listMenu = new ArrayList<Menus>();

		if (listTmenu != null && listTmenu.size() > 0) {
			for (Tmenu t : listTmenu) {
				Menus m = new Menus();
				BeanUtils.copyProperties(t, m);
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", t.getUrl());
				m.setAttributes(attributes);
				if (t.getTmenu() != null) {
					m.setPid(t.getTmenu().getId());
				}
				listMenu.add(m);
			}
		}

		return listMenu;
	}
}
