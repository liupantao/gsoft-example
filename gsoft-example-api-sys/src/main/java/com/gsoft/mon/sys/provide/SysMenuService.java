/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.provide;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.mon.sys.entity.SysMenu;

/**
 * 菜单微服务接口
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
public interface SysMenuService{
	
	/** 
	 * 根据主键查询 菜单
	 * @param id 主键
	 * @return
	 * @throws BusException 
	 */
    public SysMenu getSysMenu(String id) throws BusException;
			
    /** 
	 * 条件查询 菜单 列表
	 * @param conditions 查询条件
	 * @param orders 排序条件
	 * @return List集合
	 * @throws BusException 
	 */
    public List<SysMenu> getSysMenus(Collection<Condition> conditions,Collection<Order> orders) throws BusException;

	
}
