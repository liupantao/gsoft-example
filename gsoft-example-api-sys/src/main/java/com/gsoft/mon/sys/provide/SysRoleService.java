/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.provide;

import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.mon.sys.entity.SysRole;

/**
 * 角色 微服务接口
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
public interface SysRoleService{
	
	/** 
	 * 根据主键查询 角色
	 * @param id 主键
	 * @return
	 * @throws BusException 
	 */
    public SysRole getSysRole(String id) throws BusException;

	/**
	 * 根据角色Id集合获取授权菜单集合
	 * @param roleIds
	 * @return
	 */
	public List<String> getMenuIdsByRoles(List<String> roleIds);

	/**
	 * 根据角色Id集合获取 页面元素授权标识集合
	 * @param roleIds
	 */
	public List<String> getPermissionsByRoleIds(List<String> roleIds);
			
}
