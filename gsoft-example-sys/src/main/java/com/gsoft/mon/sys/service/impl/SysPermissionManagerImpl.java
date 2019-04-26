/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.remote.annotation.ConditionCollection;
import com.gsoft.framework.remote.annotation.OrderCollection;
import com.gsoft.framework.remote.annotation.ServiceMapping;
import com.gsoft.framework.remote.annotation.ServiceParam;
import com.gsoft.framework.remote.data.ResContext;
import com.gsoft.mon.sys.dao.SysPermissionDao;
import com.gsoft.mon.sys.entity.SysPermission;
import com.gsoft.mon.sys.service.SysPermissionManager;

/**
 * 权限ServiceImpl
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
@Service("sysPermissionManager")
@Transactional(rollbackFor = Exception.class)
public class SysPermissionManagerImpl extends BaseManagerImpl implements SysPermissionManager{
	@Autowired
	private SysPermissionDao sysPermissionDao;
	
	@Override
	@ServiceMapping(trancode="",caption="根据主键查询权限",log=false)
    public SysPermission getSysPermission(@ServiceParam(name = "id") String id) throws BusException{
    	return sysPermissionDao.findOne(id);
    }
    
	@Override
	@ServiceMapping(trancode="",caption="分页查询权限",log=false)
	public PagerRecords getPagerSysPermissions(Pager pager, 
		@ConditionCollection(domainClazz=SysPermission.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	PagerRecords pagerRecords = sysPermissionDao.findByPager(pager, conditions, orders);
		return pagerRecords;
    }
    
	@Override
	@ServiceMapping(trancode="",caption="保存权限对象",log=true)
    public SysPermission saveSysPermission(SysPermission o) throws BusException{
		return sysPermissionDao.save(o);
    }
    
    @Override
    @ServiceMapping(trancode="",caption="根据主键集合删除权限",log=true)
    public ResContext<?> removeSysPermissions(@ServiceParam(name = "id") String[] ids) throws BusException{
    	ResContext<?> res = new ResContext<>();
    	for(String id:ids){
    		SysPermission permission = sysPermissionDao.findOne(id);
    		res.log("删除:"+JSON.toJSONString(permission));
    	}
    	sysPermissionDao.delete(Arrays.asList(ids));
    	return res;
    }
    
	
}
