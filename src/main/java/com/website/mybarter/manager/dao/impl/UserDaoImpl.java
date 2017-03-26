package com.website.mybarter.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.website.mybarter.manager.dao.UserDaoI;
import com.website.mybarter.manager.model.Tuser;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Tuser> implements UserDaoI {

}
