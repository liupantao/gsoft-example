/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.provide.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.mon.sys.dao.SysRoleDao;
import com.gsoft.mon.sys.entity.SysRole;
import com.gsoft.mon.sys.provide.SysRoleService;

/**
 * 系统角色 微服务接口实现
 * 
 * @author 代码生成器
 * @date 2018-04-13
 * 
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public SysRole getSysRole(String id) throws BusException {
		return sysRoleDao.findOneByProperty("roleId", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMenuIdsByRoles(List<String> roleIds) {
		if(roleIds.size()>0){
			String sql = "select menu_id from sys_role_menu where role_id in (:roles)";
			Query query = sysRoleDao.getEntityManager().createNativeQuery(sql);
			query.setParameter("roles", roleIds);
			return query.getResultList();
		}
		return new ArrayList<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getPermissionsByRoleIds(List<String> roleIds) {
		if(roleIds.size()>0){
			String sql = "select p.perm from sys_permission p left join sys_role_perm r on p.id = r.perm_id where role_id in (:roles)";
			Query query = sysRoleDao.getEntityManager().createNativeQuery(sql);
			query.setParameter("roles", roleIds);
			return query.getResultList();
		}
		return new ArrayList<String>();
	}

}
