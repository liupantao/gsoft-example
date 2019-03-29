/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.mon.common.vo.ZTreeVo;
import com.gsoft.mon.sys.entity.SysRole;

/**
 * 系统角色Service
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
public interface SysRoleManager extends BaseManager{
	
	/** 
	 * 根据主键查询 系统角色
	 * @param id 主键
	 * @return
	 * @throws BusException 
	 */
    public SysRole getSysRole(String id) throws BusException;
    
    /**
	 * 根据主键查询 系统角色 ，并且加载参数数组中描述的延迟加载对象
	 * @param id 主键
	 * @param cAttributes 要加载的延迟对象属性
	 * @return
	 * @throws BusException 
	 */
	public SysRole getInitializeSysRole(String id,String[] cAttributes) throws BusException;
	
    /** 
	 * 获取全部 系统角色 列表
	 * @return List集合
	 * @throws BusException 
	 */
    public List<SysRole> getSysRoles() throws BusException;
    
    /** 
	 * 条件查询 系统角色 列表
	 * @param conditions 查询条件
	 * @param orders 排序条件
	 * @return List集合
	 * @throws BusException 
	 */
    public List<SysRole> getSysRoles(Collection<Condition> conditions,Collection<Order> orders) throws BusException;
    
    /**
	 * 分页查询 系统角色
	 * 
	 * @param pager 分页条件
	 * @param conditions 查询条件
	 * @param orders 排序条件
	 * @return 分页对象
	 * @throws BusException
	 */
	public PagerRecords getPagerSysRoles(Pager pager, Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
			
	
    /** 
	 * 保存 系统角色 并返回对象
	 * @param o 要保存的对象
	 * @return 保存后的对象
	 * @throws BusException 
	 */
    public SysRole saveSysRole(SysRole o) throws BusException;

    /** 
	 * 删除 系统角色 对象
	 * @param id 主键
	 * @throws BusException 
	 */
    public void removeSysRole(String id) throws BusException;
    
    
    /**
     * 根据主键集合删除 系统角色 对象
     * @param ids 主键集合
     * @throws BusException 
     */
    public void removeSysRoles(String[] ids) throws BusException;
    
     /**
     * 主键是否已经使用
     * @param id 主键
	 * @return 
     * @throws BusException 
     */
    public boolean exsitSysRole(String id) throws BusException;
    
	/**
     * 属性值是否已经使用
     * @param propertyName 属性名
     * @param value 属性值
	 * @return 
     * @throws BusException 
     */
	public boolean exsitSysRole(String propertyName,Object value) throws BusException;
	
	/**
     * 根据属性值查询列表
     * @param propertyName 属性名
     * @param value 属性值
	 * @return 
     * @throws BusException 
     */
	public List<SysRole> getSysRoleList(String propertyName,String value) throws BusException;
	
	/**
     * 根据属性值数组 查询列表
     * @param properties 属性名数组
     * @param values 属性值数组
	 * @return 
     * @throws BusException 
     */
	public List<SysRole> getSysRoleList(String[] properties,Object[] values) throws BusException;
	
	/**
     * 查找propertyA或者propertyB like term的集合
     * @param propertyA 属性A
     * @param propertyB 属性B
     * @param term 查询字符串
	 * @return 
     * @throws BusException 
     */
	public List<SysRole> findStartByTermOnAOrB(String propertyA, String propertyB, String term) throws BusException;
	
	/**
     * 更新属性值
     * @param propertyName 属性名
     * @param oldValue 旧属性值
     * @param newValue 新属性值
     * @throws BusException 
     */
	public void updatePropertyValue(String propertyName, Object oldValue, Object newValue) throws BusException;

	/**
	 * 获取角色授权菜单zTree
	 * @param roleId
	 * @return
	 */
	List<ZTreeVo> getMenuTreeByRoleId(String roleId);
	
	/**
	 * 保存角色及授权
	 * @param sysRole
	 * @return
	 */
	SysRole saveRoleAuth(SysRole sysRole);
	
}
