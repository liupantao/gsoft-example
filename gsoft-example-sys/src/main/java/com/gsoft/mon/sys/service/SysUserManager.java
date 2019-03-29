/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service;

import java.util.Collection;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.BaseManager;
import com.gsoft.framework.remote.data.ResContext;
import com.gsoft.mon.sys.entity.SysUser;

/**
 * 系统用户Service
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
public interface SysUserManager extends BaseManager{
	
	/** 
	 * 根据主键查询 系统用户
	 * @param id 主键
	 * @return
	 * @throws BusException 
	 */
    public SysUser getSysUser(String id) throws BusException;
    
    /**
	 * 分页查询 系统用户
	 * 
	 * @param pager 分页条件
	 * @param conditions 查询条件
	 * @param orders 排序条件
	 * @return 分页对象
	 * @throws BusException
	 */
	public PagerRecords getPagerSysUsers(Pager pager, Collection<Condition> conditions, Collection<Order> orders)
			throws BusException;
			
	
    /** 
	 * 注册 系统用户 并返回对象
	 * @param o 要保存的对象
	 * @return 保存后的对象
	 * @throws BusException 
	 */
    public SysUser registSysUser(SysUser o) throws BusException;
    
    /** 
	 * 更新 系统用户 并返回对象
	 * @param o 要保存的对象
	 * @return 保存后的对象
	 * @throws BusException 
	 */
    public SysUser updateSysUser(SysUser o) throws BusException;

    /**
     * 授权用户角色
     * @param o
     * @return
     * @throws BusException
     */
    public SysUser authSysUser(SysUser o) throws BusException;
    
    /** 
     * 重置密码
     * @param id
     * @return 
     */
    public ResContext<?> restPassword(String id);
    
    /** 
	 * 删除 系统用户 对象
	 * @param id 主键
	 * @throws BusException 
	 */
    public void removeSysUser(String id) throws BusException;
    
    
    /**
     * 根据主键集合删除 系统用户 对象
     * @param ids 主键集合
     * @throws BusException 
     */
    public void removeSysUsers(String[] ids) throws BusException;
    

}
