/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.provide.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.mon.sys.dao.SysMenuDao;
import com.gsoft.mon.sys.entity.SysMenu;
import com.gsoft.mon.sys.provide.SysMenuService;

/**
 * 系统菜单 微服务接口实现
 * 
 * @author 代码生成器
 * @date 2018-04-13
 * 
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;

	@Override
	public SysMenu getSysMenu(String id) throws BusException {
		return sysMenuDao.findOneByProperty("menuId", id);
	}

	@Override
	public List<SysMenu> getSysMenus(Collection<Condition> conditions, Collection<Order> orders) throws BusException {
		return sysMenuDao.commonQuery(conditions, orders);
	}
}
