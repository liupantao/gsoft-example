/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.provide.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.mon.sys.dao.SysUserDao;
import com.gsoft.mon.sys.entity.SysUser;
import com.gsoft.mon.sys.provide.SysUserService;

/**
 * 系统用户 微服务接口实现
 * 
 * @author 代码生成器
 * @date 2018-04-13
 * 
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUser getSysUser(String id) throws BusException {
		SysUser user = sysUserDao.findOneByProperty("id", id);
		if (user != null) {
			sysUserDao.initializeObjectCollections(user, new String[] { "roles" });
		}
		return user;
	}

	@Override
	public SysUser getSysUserByUserName(String username) throws BusException {
		SysUser user = sysUserDao.findOneByProperty("username", username);
		if (user != null) {
			sysUserDao.initializeObjectCollections(user, new String[] { "roles" });
		}
		return user;
	}

}
