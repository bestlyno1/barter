package com.website.mybarter.manager.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.mybarter.manager.dao.UserDaoI;
import com.website.mybarter.manager.model.Tuser;
import com.website.mybarter.manager.pagemodel.DataGrid;
import com.website.mybarter.manager.pagemodel.User;
import com.website.mybarter.manager.service.UserServiceI;
import com.website.mybarter.manager.util.Encrypt;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	private UserDaoI userDao;

	public UserDaoI getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Override
	public Serializable addUser(User user) {
		Tuser t = new Tuser();
		// 对应属性拷贝
		BeanUtils.copyProperties(user, t, new String[] { "pwd" });
		t.setId(UUID.randomUUID().toString());
		t.setCreatedatetime(new Date());
		t.setPwd(Encrypt.e(user.getPwd()));
		return userDao.save(t);
	}

	@Override
	public User login(User user) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", user.getUsername());
		params.put("pwd", Encrypt.e(user.getPwd()));

		Tuser t = userDao.get("from Tuser t where t.name = :name and t.pwd = :pwd", params);

		if (t != null) {
			return user;
		}

		return null;
	}

	@Override
	public DataGrid getUserList(User parUser) {
		Map<String, Object> where = new HashMap<String, Object>();
		String hql = "from Tuser t";
		hql = addWhere(parUser, hql, where);

		String totalHql = "select count(*) " + hql;
		hql = addOrder(parUser, hql);

		List<Tuser> listTuser = userDao.find(hql, where, parUser.getPage(), parUser.getRows());
		List<User> listUser = new ArrayList<User>();

		changeModel(listTuser, listUser);

		DataGrid dg = new DataGrid();
		dg.setTotal(userDao.count(totalHql, where));
		dg.setRows(listUser);
		return dg;
	}

	private void changeModel(List<Tuser> listTuser, List<User> listUser) {
		if (listTuser != null && listTuser.size() > 0) {
			for (Tuser t : listTuser) {
				User u = new User();
				BeanUtils.copyProperties(t, u);
				listUser.add(u);
			}
		}
	}

	private String addOrder(User parUser, String hql) {
		if (parUser.getSort() != null && !"".equals(parUser.getSort())) {
			hql += " order by " + parUser.getSort() + " " + parUser.getOrder();
		}
		return hql;
	}

	private String addWhere(User parUser, String hql, Map<String, Object> where) {
		if (parUser.getUsername() != null && !"".equals(parUser.getUsername())) {
			hql += " where t.name like :name ";
			where.put("name", "%" + parUser.getUsername() + "%");
		}
		return hql;
	}
}
