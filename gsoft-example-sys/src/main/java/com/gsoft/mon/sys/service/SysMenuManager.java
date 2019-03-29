/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service;

import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.security.vo.MenuTreeVo;
import com.gsoft.mon.sys.entity.SysMenu;

/**
 * 系统菜单Service
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
public interface SysMenuManager extends BaseManager{
	
	/**
	 * 获取系统菜单树结构
	 * @return
	 */
	public List<MenuTreeVo> getSysMenuTrees();
	/** 
	 * 根据主键查询 系统菜单
	 * @param id 主键
	 * @return
	 * @throws BusException 
	 */
    public SysMenu getSysMenu(String id) throws BusException;
	
    /** 
	 * 保存 系统菜单 并返回对象
	 * @param o 要保存的对象
	 * @return 保存后的对象
	 * @throws BusException 
	 */
    public SysMenu saveSysMenu(SysMenu o) throws BusException;

    /** 
	 * 删除 系统菜单 对象
	 * @param id 主键
	 * @throws BusException 
	 */
    public void removeSysMenu(String id) throws BusException;
    
	
}
