/*
 * 
 */
package com.gsoft.mon.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.core.dataobj.tree.TreeAttribute;
import com.gsoft.framework.core.web.menu.IMenu;

/**
 * 
 * @author LiuPeng
 *
 */
@Entity
@Table(name = "SYS_MENU")
public class SysMenu implements Domain, IMenu {

	private static final long serialVersionUID = -3104266908999847709L;

	@Id
	@Column(name = "MENU_ID")
	@Length(max = 32)
	private String menuId;

	/**
	 * 父菜单
	 */
	@Column(name = "PARENT_MENU_ID")
	@Length(max = 32)
	private String parentMenuId;

	/**
	 * 菜单地址
	 */
	@Column(name = "MENU_SRC")
	@Length(max = 800)
	private String menuSrc;

	/**
	 * 菜单样式
	 */
	@Column(name = "MENU_STYLE")
	@Length(max = 60)
	private String menuStyle;
	
	/**
	 * 菜单名称
	 */
	@Column(name = "MENU_CAPTION")
	@Length(max = 30)
	private String menuCaption;
	
	/**
	 * target
	 */
	@Column(name = "MENU_TARGET")
	@Length(max = 30)
	private String target;

	/**
	 * 菜单顺序
	 */
	@Column(name = "MENU_INDEX")
	@Length(max = 3)
	private String menuIndex;

	@Override
	@TreeAttribute(value = TreeAttribute.TREE_ATTR_ID)
	public String getMenuId() {
		return menuId;
	}

	@Override
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	@TreeAttribute(value = TreeAttribute.TREE_ATTR_PID)
	public String getParentMenuId() {
		return parentMenuId;
	}

	@Override
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	@Override
	@TreeAttribute(value = TreeAttribute.TREE_ATTR_HREF)
	public String getMenuSrc() {
		return menuSrc;
	}

	@Override
	public void setMenuSrc(String menuSrc) {
		this.menuSrc = menuSrc;
	}

	@Override
	@TreeAttribute(value = TreeAttribute.TREE_ATTR_GOURP)
	public String getMenuStyle() {
		return menuStyle;
	}

	@Override
	public void setMenuStyle(String menuStyle) {
		this.menuStyle = menuStyle;
	}

	public String getMenuIndex() {
		return menuIndex;
	}

	public void setMenuIndex(String menuIndex) {
		this.menuIndex = menuIndex;
	}

	@Override
	@TreeAttribute(value = TreeAttribute.TREE_ATTR_TEXT)
	public String getMenuCaption() {
		return menuCaption;
	}

	@Override
	public void setMenuCaption(String menuCaption) {
		this.menuCaption = menuCaption;
	}

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public void setTarget(String target) {
		this.target = target;
	}

}