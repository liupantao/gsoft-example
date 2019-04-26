/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsoft.framework.core.dataobj.tree.HtmlTreeNode;
import com.gsoft.framework.core.dataobj.tree.TreeNode;
import com.gsoft.framework.core.dataobj.tree.TreeUtils;
import com.gsoft.framework.core.exception.BusException;
import com.gsoft.framework.core.orm.Condition;
import com.gsoft.framework.core.orm.Order;
import com.gsoft.framework.core.service.impl.BaseManagerImpl;
import com.gsoft.framework.remote.annotation.ServiceMapping;
import com.gsoft.framework.remote.annotation.ServiceParam;
import com.gsoft.framework.security.vo.MenuTreeVo;
import com.gsoft.framework.util.ConditionUtils;
import com.gsoft.framework.util.StringUtils;
import com.gsoft.mon.sys.dao.SysMenuDao;
import com.gsoft.mon.sys.entity.SysMenu;
import com.gsoft.mon.sys.service.SysMenuManager;

/**
 * 系统菜单ServiceImpl
 * 
 * @author 代码生成器
 * @date 2018-04-13
 * 
 */
@Service("sysMenuManager")
@Transactional(rollbackFor = Exception.class)
public class SysMenuManagerImpl extends BaseManagerImpl implements SysMenuManager {
	@Autowired
	private SysMenuDao sysMenuDao;

	@Override
	@ServiceMapping(trancode = "", caption = "获取系统菜单树", log = false)
	public List<MenuTreeVo> getSysMenuTrees() {
		List<MenuTreeVo> menuTree = new ArrayList<MenuTreeVo>();
		Collection<Order> orders = new ArrayList<>();
		orders.add(ConditionUtils.getOrder("menuIndex", true));
		List<SysMenu> sysMenus = sysMenuDao.commonQuery(new ArrayList<Condition>(), orders);
		HtmlTreeNode tree = TreeUtils.listToHtmlTree(sysMenus, null, "系统菜单");
		if (tree != null) {
			List<TreeNode> children = tree.getChildren();
			for (TreeNode treeNode : children) {
				MenuTreeVo menuTreeVo = buildMenuTreeVo(treeNode);
				menuTree.add(menuTreeVo);
			}
		}
		return menuTree;
	}

	private MenuTreeVo buildMenuTreeVo(TreeNode treeNode) {
		MenuTreeVo menuTreeVo = new MenuTreeVo(treeNode);
		if (treeNode.getChildren() != null && treeNode.getChildren().size() > 0) {
			List<MenuTreeVo> childrenMenus = new ArrayList<>();
			List<TreeNode> children = treeNode.getChildren();
			for (TreeNode c : children) {
				MenuTreeVo cMenuTreeVo = buildMenuTreeVo(c);
				childrenMenus.add(cMenuTreeVo);
			}
			menuTreeVo.setChildren(childrenMenus);
		}
		return menuTreeVo;
	}

	@Override
	@ServiceMapping(trancode = "", caption = "根据主键查询系统菜单", log = false)
	public SysMenu getSysMenu(@ServiceParam(name = "id") String id) throws BusException {
		return sysMenuDao.findOne(id);
	}

	@Override
	@ServiceMapping(trancode = "", caption = "保存系统菜单对象", log = true)
	public SysMenu saveSysMenu(SysMenu o) throws BusException {
		String sysMenuId = o.getMenuId();
		boolean isUpdate = StringUtils.isNotEmpty(sysMenuId);
		if (isUpdate) {
			SysMenu dbMenu = sysMenuDao.findOne(sysMenuId);
			dbMenu.setMenuCaption(o.getMenuCaption());
			dbMenu.setMenuSrc(o.getMenuSrc());
			dbMenu.setMenuIndex(o.getMenuIndex());
			dbMenu.setMenuStyle(o.getMenuStyle());
			o = dbMenu;
		} else {// 新增
			
		}
		return sysMenuDao.save(o);
	}
	
	@Override
	@ServiceMapping(trancode = "", caption = "根据主键删除系统菜单", log = true)
	public void removeSysMenu(@ServiceParam(name = "id") String id) throws BusException {
		sysMenuDao.delete(id);
	}

}
