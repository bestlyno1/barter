package com.website.mybarter.manager.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.website.mybarter.manager.dao.MenuDaoI;
import com.website.mybarter.manager.model.Tmenu;

/**
 * 类功能说明 类修改者 修改日期 修改说明
 * <p>
 * Title: MenuDaoImpl.java
 * </p>
 * <p>
 * Description: wp科技开发平台
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: wp科技有限公司
 * </p>
 * 
 * @author 王鹏
 * @date 2014年9月4日 下午9:44:07
 * @version V1.0
 */
@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Tmenu> implements MenuDaoI {

	/**
	 * 获得数的根节点
	 * 
	 * @author 王鹏
	 * @日期 2014年9月4日
	 * @return
	 */
	@Override
	public List<Tmenu> getTree() {
		return this.find("from Tmenu t where t.tmenu is null");
	}

	/**
	 * 异步加载数节点
	 * 
	 * @author 王鹏
	 * @日期 2014年9月4日
	 * @param params
	 * @return
	 */
	@Override
	public List<Tmenu> getTreeById(Map<String, Object> params) {
		return this.find("from Tmenu t where t.tmenu.id = :id", params);
	}

	/**
	 * 获得全部数节点
	 * 
	 * @author 王鹏
	 * @日期 2014年9月4日
	 * @return
	 */
	@Override
	public List<Tmenu> getAllTree() {
		return this.find("from Tmenu t");
	}
}
