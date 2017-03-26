package com.website.mybarter.manager.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.website.mybarter.manager.pagemodel.Menus;
import com.website.mybarter.manager.service.MenuServiceI;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menus> {

	private Menus menu = new Menus();
	private MenuServiceI menuService;

	public MenuServiceI getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	@Override
	public Menus getModel() {
		return menu;
	}

	public void getTree() {
		super.writeJson(menuService.getTree(menu.getId()));
	}

	public void getAllTree() {
		super.writeJson(menuService.getAllTree());
	}
}
