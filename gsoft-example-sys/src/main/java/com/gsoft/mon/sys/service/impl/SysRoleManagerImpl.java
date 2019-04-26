/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.gsoft.framework.util.Assert;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mon.common.vo.ZTreeVo;
import com.gsoft.mon.sys.dao.SysMenuDao;
import com.gsoft.mon.sys.dao.SysPermissionDao;
import com.gsoft.mon.sys.dao.SysRoleDao;
import com.gsoft.mon.sys.entity.SysMenu;
import com.gsoft.mon.sys.entity.SysPermission;
import com.gsoft.mon.sys.entity.SysRole;
import com.gsoft.mon.sys.service.SysRoleManager;

/**
 * 系统角色ServiceImpl
 * @author 代码生成器
 * @date 2018-04-13
 *  
 */
@Service("sysRoleManager")
@Transactional(rollbackFor = Exception.class)
public class SysRoleManagerImpl extends BaseManagerImpl implements SysRoleManager{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysPermissionDao sysPermissionDao;
	
	@SuppressWarnings("unchecked")
	@Override
	@ServiceMapping(trancode="",caption="获取角色授权菜单zTree",log=false)
	public List<ZTreeVo> getMenuTreeByRoleId(@ServiceParam(name = "roleId") String roleId) {
		//角色菜单
		List<String> authMenuIds = new ArrayList<>();
		if(StringUtils.isNotEmpty(roleId)){
			String sql = "select menu_id from sys_role_menu where role_id = :roleId ";
			Query query = sysRoleDao.getEntityManager().createNativeQuery(sql);
			query.setParameter("roleId", roleId);
			authMenuIds = query.getResultList();
		}
		
		//角色权限
		List<String> authPermIds = new ArrayList<>();
		if(StringUtils.isNotEmpty(roleId)){
			String sql = "select perm_id from sys_role_perm where role_id = :roleId ";
			Query query = sysRoleDao.getEntityManager().createNativeQuery(sql);
			query.setParameter("roleId", roleId);
			authPermIds = query.getResultList();
		}
		
		//所有菜单
		Collection<Order> orders = new ArrayList<>();
		orders.add(ConditionUtils.getOrder("menuIndex", true));
		List<SysMenu> sysMenus = sysMenuDao.commonQuery(new ArrayList<Condition>(), orders );
		//所有权限
		List<SysPermission> sysPermissions = sysPermissionDao.findAll();
		Map<String, List<SysPermission>> menuPermissionMap = new HashMap<String, List<SysPermission>>(16);
		for(SysPermission sysPermission:sysPermissions){
			List<SysPermission> permissions = menuPermissionMap.get(sysPermission.getMenuId());
			if(permissions==null){
				permissions = new ArrayList<>();
			}
			permissions.add(sysPermission);
			menuPermissionMap.put(sysPermission.getMenuId(), permissions);
		}
		
		List<ZTreeVo> zTreeMenus = new ArrayList<>();
		for(SysMenu sysmenu:sysMenus){
			// 树-添加菜单
			ZTreeVo zTreeVo = new ZTreeVo(sysmenu.getMenuId(), sysmenu.getParentMenuId(), sysmenu.getMenuCaption());
			zTreeVo.setOpen(true);
			zTreeVo.setChecked(authMenuIds.contains(sysmenu.getMenuId()));
			zTreeMenus.add(zTreeVo);
			if(menuPermissionMap.containsKey(sysmenu.getMenuId())){
				//树-添加权限
				for(SysPermission permission:menuPermissionMap.get(sysmenu.getMenuId())){
					ZTreeVo zTreePerm = new ZTreeVo(permission.getId(), sysmenu.getMenuId(), ">>"+permission.getName());
					zTreePerm.setType("perm");
					zTreePerm.setOpen(true);
					zTreePerm.setChecked(authPermIds.contains(permission.getId()));
					zTreeMenus.add(zTreePerm);
				}
			}
		}
		return zTreeMenus;
	}
	
	@Override
	@ServiceMapping(trancode="",caption="保存角色及授权",log=true)
	public SysRole saveRoleAuth(SysRole sysRole){
		Assert.notNull(sysRole,"角色参数不能为空");
		return sysRoleDao.save(sysRole);
	}

	
	@Override
	@ServiceMapping(trancode="",caption="根据主键查询系统角色",log=false)
    public SysRole getSysRole(@ServiceParam(name = "id") String id) throws BusException{
    	return sysRoleDao.findOne(id);
    }
    
	@Override
	public SysRole getInitializeSysRole(String id,String[] cAttributes) throws BusException{
		return sysRoleDao.findOneInitialize(id,cAttributes);
	}
    
	@Override
    public List<SysRole> getSysRoles() throws BusException{
    	return sysRoleDao.findAll();
    }
    
	@Override
	@ServiceMapping(trancode="",caption="查询系统角色集合",log=false)
    public List<SysRole> getSysRoles(
    	@ConditionCollection(domainClazz=SysRole.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
    	return sysRoleDao.commonQuery(conditions, orders);
    }
    
	@Override
	@ServiceMapping(trancode="",caption="分页查询系统角色",log=false)
	public PagerRecords getPagerSysRoles(Pager pager, 
		@ConditionCollection(domainClazz=SysRole.class) Collection<Condition> conditions,
    	@OrderCollection Collection<Order> orders) throws BusException{
		orders.add(ConditionUtils.getOrder("roleId", true));
    	PagerRecords pagerRecords = sysRoleDao.findByPager(pager, conditions, orders);
		return pagerRecords;
    }
    
	@Override
    public SysRole saveSysRole(SysRole o) throws BusException{
//    	String SysRoleId = o.getSysRoleId();
//    	boolean isUpdate = StringUtils.isNotEmpty(SysRoleId);
//    	if(isUpdate){//修改
//    	
//    	}else{//新增
//    		
//    	}
		return sysRoleDao.save(o);
    }
    
	@Override
	@ServiceMapping(trancode="",caption="根据主键删除系统角色",log=true)
    public void removeSysRole(@ServiceParam(name = "id") String id) throws BusException{
    	sysRoleDao.delete(id);
    }

    @Override
    @ServiceMapping(trancode="",caption="根据主键集合删除系统角色",log=true)
    public void removeSysRoles(@ServiceParam(name = "id") String[] ids) throws BusException{
    	sysRoleDao.delete(Arrays.asList(ids));
    }
    
	/**
     * 主键是否已经使用
     * @param id 主键
     * @return 
     * @throws BusException 
     */
    @Override
    public boolean exsitSysRole(String id) throws BusException{
    	return sysRoleDao.exists(id);
    }
        
  	/**
     * 属性值是否已经使用
     * @param propertyName 属性名
     * @param value 属性值
	 * @return 
     * @throws BusException 
     */
    @Override
	public boolean exsitSysRole(String propertyName,Object value) throws BusException{
		return sysRoleDao.exists(propertyName, value);
	}
	
	/**
     * 根据属性值查询列表
     * @param propertyName 属性名
     * @param value 属性值
	 * @return 
     * @throws BusException 
     */
    @Override
	public List<SysRole> getSysRoleList(String propertyName,String value) throws BusException{
		return sysRoleDao.findList(propertyName, value);
	}
	
	/**
     * 根据属性值数组 查询列表
     * @param properties 属性名数组
     * @param values 属性值数组
	 * @return 
     * @throws BusException 
     */
    @Override
	public List<SysRole> getSysRoleList(String[] properties,Object[] values) throws BusException{
		return sysRoleDao.findList(properties, values);
	}
	
	/**
     * 查找propertyA或者propertyB like term的集合
     * @param propertyA 属性A
     * @param propertyB 属性B
     * @param term 查询字符串
	 * @return 
     * @throws BusException 
     */
    @Override
	public List<SysRole> findStartByTermOnAOrB(String propertyA, String propertyB, String term) throws BusException{
		return sysRoleDao.findStartByTermOnAOrB(propertyA, propertyB, term);
	}
	
	/**
     * 更新属性值
     * @param propertyName 属性名
     * @param oldValue 旧属性值
     * @param newValue 新属性值
     * @throws BusException 
     */
    @Override
	public void updatePropertyValue(String propertyName, Object oldValue, Object newValue) throws BusException{
		sysRoleDao.update(propertyName,oldValue,newValue);
	}
	
}
