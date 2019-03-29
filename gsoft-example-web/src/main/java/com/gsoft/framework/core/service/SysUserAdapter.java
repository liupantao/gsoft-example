package com.gsoft.framework.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.web.menu.IMenu;
import com.gsoft.framework.security.IPasswordService;
import com.gsoft.framework.security.IRealmUserInfo;
import com.gsoft.framework.security.IRealmUserToken;
import com.gsoft.framework.security.IUser;
import com.gsoft.framework.security.IUserAdapter;
//import com.gsoft.framework.security.authc.UserHashedCredentialsMatcher;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.mon.sys.entity.SysMenu;
import com.gsoft.mon.sys.entity.SysUser;
import com.gsoft.mon.sys.entity.SysUserAccount;
import com.gsoft.mon.sys.provide.SysMenuService;
import com.gsoft.mon.sys.provide.SysRoleService;
import com.gsoft.mon.sys.provide.SysUserService;

/**
 * 
 * 平台用户扩展适配服务
 * 
 * @author liupeng
 *
 */
@Service("sysUserService")
@Transactional(rollbackFor = Exception.class)
public class SysUserAdapter implements IUserAdapter<SysUser>, IPasswordService {

	@Reference
	private SysUserService sysUserService;

	@Reference
	private SysMenuService sysMenuService;

	@Reference
	private SysRoleService sysRoleService;

	@Override
	public void modifyPassword(String username, String password, String confirmPassword, String oldPassword) {
//		sysUserService.updatePassword(username, password, confirmPassword, oldPassword);
	}

	@Override
	public boolean supports(IRealmUserToken token) {
		// return
		// DefaultLoginFormToken.class.isAssignableFrom(token.getClass());
		return true;
	}

	@Override
	public boolean supports(IUser user) {
		return SysUser.class.isAssignableFrom(user.getClass());
	}

	@Override
	public IRealmUserInfo getRealmUserInfo(IRealmUserToken token) {
		return getUserInfoByUsername(token.getUsername());
	}

	@Override
	public IRealmUserInfo getRealmUserInfo(SysUser user) {
		return getUserInfoByUsername(user.getUsername());
	}

	private IRealmUserInfo getUserInfoByUsername(String username) {
		SysUser user = sysUserService.getSysUserByUserName(username);
		// 未查询到用户直接返回
		if (user == null) {
			return null;
		}
		SysUserAccount loginUser = new SysUserAccount(user);
		List<String> permissions = sysRoleService.getPermissionsByRoleIds(user.roleIds());
		loginUser.setPermissions(permissions);
		return loginUser;
	}

	@Override
	public List<IMenu> getProviderMenus(SysUser user) {
		Collection<Order> orders = new ArrayList<Order>();
		orders.add(ConditionUtils.getOrder("menuIndex", true));
		List<SysMenu> menus = sysMenuService.getSysMenus(new ArrayList<Condition>(), orders);
		List<IMenu> providerMenus = new ArrayList<IMenu>();
		for (SysMenu menu : menus) {
			providerMenus.add(menu);
		}
		return providerMenus;
	}

	@Override
	public List<String> getAccountMenus(SysUser user) {
		return sysRoleService.getMenuIdsByRoles(user.roleIds());
	}

}
