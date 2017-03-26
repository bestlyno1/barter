package com.website.mybarter.manager.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.mybarter.manager.dao.MenuDaoI;
import com.website.mybarter.manager.dao.UserDaoI;
import com.website.mybarter.manager.model.Tmenu;
import com.website.mybarter.manager.model.Tuser;
import com.website.mybarter.manager.service.RepairServiceI;
import com.website.mybarter.manager.util.Encrypt;

@Service("repairService")
public class RepairServiceImpl implements RepairServiceI {

	private MenuDaoI menuDao;
	private UserDaoI userDao;

	public UserDaoI getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	public MenuDaoI getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(MenuDaoI menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public void repair() {
		repairMenu();
		repairUser();
	}

	private void repairMenu() {
		Tmenu root = new Tmenu();
		root.setId("0");
		root.setText("首页");
		root.setUrl("");
		menuDao.saveOrUpdate(root);

		Tmenu xtgl = new Tmenu();
		xtgl.setId("xtgl");
		xtgl.setTmenu(root);
		xtgl.setText("系统管理");
		xtgl.setUrl("");
		menuDao.saveOrUpdate(xtgl);

		Tmenu yhgl = new Tmenu();
		yhgl.setId("yhgl");
		yhgl.setTmenu(xtgl);
		yhgl.setText("用户管理");
		yhgl.setUrl("/user/account.jsp");
		menuDao.saveOrUpdate(yhgl);

		Tmenu jsgl = new Tmenu();
		jsgl.setId("jsgl");
		jsgl.setTmenu(xtgl);
		jsgl.setText("角色管理");
		menuDao.saveOrUpdate(jsgl);

		Tmenu qxgl = new Tmenu();
		qxgl.setId("qxgl");
		qxgl.setTmenu(xtgl);
		qxgl.setText("权限管理");
		menuDao.saveOrUpdate(qxgl);

		Tmenu cdgl = new Tmenu();
		cdgl.setId("cdgl");
		cdgl.setTmenu(xtgl);
		cdgl.setText("菜单管理");
		menuDao.saveOrUpdate(cdgl);

		Tmenu buggl = new Tmenu();
		buggl.setId("buggl");
		buggl.setTmenu(xtgl);
		buggl.setText("BUG管理");
		menuDao.saveOrUpdate(buggl);
	}

	private void repairUser() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "admin");

		Tuser t = userDao.get("from Tuser t where t.name = :name and t.id != '0'", params);
		if (t != null) {
			t.setName(t.getName() + "_errorName");
		}

		Tuser admin = new Tuser();
		admin.setId("0");
		admin.setName("1");
		admin.setPwd(Encrypt.e("1"));
		admin.setModifydatetime(new Date());
		userDao.saveOrUpdate(admin);
	}
}
