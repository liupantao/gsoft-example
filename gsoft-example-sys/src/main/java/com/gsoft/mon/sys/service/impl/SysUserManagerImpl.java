/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.orm.Pager;
import com.gsoft.framework.core.orm.PagerRecords;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.core.web.view.Message;
import com.gsoft.framework.remote.annotation.ConditionCollection;
import com.gsoft.framework.remote.annotation.InitializeProperty;
import com.gsoft.framework.remote.annotation.OrderCollection;
import com.gsoft.framework.remote.annotation.ServiceMapping;
import com.gsoft.framework.remote.annotation.ServiceParam;
import com.gsoft.framework.remote.data.ResContext;
import com.gsoft.framework.security.authc.UserHashedCredentialsMatcher;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.framework.util.ValidataFactory;
import com.gsoft.mon.sys.dao.SysUserDao;
import com.gsoft.mon.sys.entity.SysRole;
import com.gsoft.mon.sys.entity.SysUser;
import com.gsoft.mon.sys.provide.SysConvertService;
import com.gsoft.mon.sys.service.SysUserManager;

/**
 * 系统用户ServiceImpl
 * 
 * @author 代码生成器
 * @date 2018-04-13
 * 
 */
@Service("sysUserManager")
@Transactional(rollbackFor = Exception.class)
public class SysUserManagerImpl extends BaseManagerImpl implements SysUserManager,InitializingBean {

	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private UserHashedCredentialsMatcher userHashedCredentialsMatcher;


	@Reference
	private SysConvertService convertService;
	
	
	@Override
	@ServiceMapping(trancode = "", caption = "根据主键查询系统用户", log = false)
	public SysUser getSysUser(@ServiceParam(name = "id") String id) throws BusException {
		SysUser user = sysUserDao.findOneByProperty("id", id);
		if (user != null) {
			sysUserDao.initializeObjectCollections(user, new String[] { "roles" });
		}
		return user;
	}

	@Override
	@ServiceMapping(trancode = "", caption = "分页查询系统用户", initializeProperties = {
			@InitializeProperty(value = "roles") }, log = false)
	public PagerRecords getPagerSysUsers(Pager pager,
			@ConditionCollection(domainClazz = SysUser.class) Collection<Condition> conditions,
			@OrderCollection Collection<Order> orders) throws BusException {
		PagerRecords pagerRecords = sysUserDao.findByPager(pager, conditions, orders);
		return pagerRecords;
	}

	@Override
	@ServiceMapping(trancode = "", caption = "注册系统用户对象", log = true)
	public SysUser registSysUser(SysUser o) throws BusException {
		String sysUserId = o.getId();
		boolean isUpdate = StringUtils.isNotEmpty(sysUserId);
		if (isUpdate) {
			// 修改
			throw new BusException("注册接口不允许修改");
		}
		ValidataFactory validataFactory = ValidataFactory.create().notEmpty("平台ID", "companyId")
				.notEmpty("用户类型", "userType").notEmpty("用户账号", "username").notEmpty("用户名称", "name")
				.notEmpty("密码", "password").notEmpty("手机号", "tel");
		if (!validataFactory.validateSuccess()) {
			throw new BusException(validataFactory.getMessage());
		}
		if (sysUserDao.exists("username", o.getUsername())) {
			throw new BusException("用户名已存在");
		}
		
		o.setPassword(userHashedCredentialsMatcher.hashPassword(o.getPassword()).toHex());

		// 创建日期
		o.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		return sysUserDao.save(o);
	}

	@Override
	@ServiceMapping(trancode = "", caption = "更新系统用户对象", log = true)
	public SysUser updateSysUser(SysUser o) throws BusException {
		SysUser sysUser = sysUserDao.findOne(o.getId());
		o.setPassword(sysUser.getPassword());
		o.setStatus(sysUser.getStatus());
		o.setRoles(sysUser.getRoles());/** 角色集合 */
		// TODO 更新用户信息
		return sysUserDao.save(o);
	}

	@Override
	@ServiceMapping(trancode = "", caption = "授权系统用户对象", log = true)
	public SysUser authSysUser(SysUser o) throws BusException {
		String sysUserId = o.getId();
		boolean isUpdate = StringUtils.isNotEmpty(sysUserId);
		if (!isUpdate) {
			throw new BusException("未找到用户信息");
		}
		List<SysRole> roles = new ArrayList<>();
		List<SysRole> authRoles = o.getRoles();
		if (authRoles != null) {
			for (SysRole role : authRoles) {
				if (!StringUtils.isEmpty(role.getRoleId())) {
					roles.add(role);
				}
			}
		}
		SysUser dbUser = sysUserDao.findOne(o.getId());
		dbUser.setRoles(roles);
		return sysUserDao.save(dbUser);
	}

	/*
	 * @param id
	 * 
	 * @return
	 * 
	 * @see com.gsoft.yoreach.sys.service.SysUserManager#restPassword(java.lang.
	 * String)
	 */
	@Override
	@ServiceMapping(trancode = "", caption = "重置密码", log = true)
	public ResContext<?> restPassword(@ServiceParam(name = "id") String id) {
		ResContext<?> resContext = new ResContext<>();
		SysUser sysUser = sysUserDao.findOne(id);
		resContext.setMessage(new Message("0", "重置密码成功"));
		return resContext;
	}

	@Override
	@ServiceMapping(trancode = "", caption = "根据主键删除系统用户", log = true)
	public void removeSysUser(@ServiceParam(name = "id") String id) throws BusException {
		sysUserDao.delete(id);
	}

	@Override
	@ServiceMapping(trancode = "", caption = "根据主键集合删除系统用户", log = true)
	public void removeSysUsers(@ServiceParam(name = "id") String[] ids) throws BusException {
		sysUserDao.delete(Arrays.asList(ids));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(userHashedCredentialsMatcher.hashPassword("123456").toHex());
	}


}
