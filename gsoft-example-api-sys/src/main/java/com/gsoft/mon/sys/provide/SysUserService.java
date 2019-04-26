/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.provide;

import com.gsoft.framework.core.exception.BusException;
import com.gsoft.mon.sys.entity.SysUser;

/**
 * 系统用户 微服务接口
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
public interface SysUserService{
	
	/** 
	 * 根据主键查询 系统用户
	 * @param id 主键
	 * @return
	 * @throws BusException 
	 */
    public SysUser getSysUser(String id) throws BusException;
    
    
    /**
     * @param username
     * @return
     * @throws BusException
     */
    public SysUser getSysUserByUserName(String username) throws BusException;

}
