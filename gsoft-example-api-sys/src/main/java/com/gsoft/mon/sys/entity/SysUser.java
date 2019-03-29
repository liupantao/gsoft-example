/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.alibaba.fastjson.annotation.JSONField;
import com.gsoft.framework.core.dataobj.Domain;
import com.gsoft.framework.security.IUser;
import com.gsoft.framework.security.PrincipalConfig;

/**
 * 实体: 系统用户
 * 
 * @author 代码生成器
 * @date 2018-04-13
 * 
 */
@Entity
@Table(name = "SYS_USER")
public class SysUser implements Domain, IUser {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "ID")
	@Length(max = 32)
	private String id;

	/**
	 * @Fields 用户账号
	 */
	@Column(name = "USERNAME", nullable = false)
	@Length(max = 40)
	private String username;
	
	/**
	 * @Fields 密码
	 */
	@JSONField(serialize=false)
	@Column(name = "PASSWORD", nullable = false)
	@Length(max = 40)
	private String password;
	
	/**
	 * @Fields 帐号状态
	 */
	@Column(name = "STATUS", nullable = false)
	@Length(max = 1)
	private String status;
	
	/**
	 * @Fields 创建时间
	 */
	@Column(name = "CREATE_TIME", nullable = false)
	@Length(max=20)
	private String createTime;

	/**
	 * 角色集合
	 */
	@ManyToMany(targetEntity = SysRole.class)
	@JoinTable(
			name = "SYS_USER_ROLE", 
			joinColumns = { @JoinColumn(name = "USER_ID") }, 
			inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
		)
	private List<SysRole> roles;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getLoginName() {
		return this.username;
	}

	@Override
	public PrincipalConfig getPrincipalConfig() {
		PrincipalConfig principalConfig = new PrincipalConfig();
		return principalConfig;
	}

	@Override
	public List<String> roleIds() {
		List<String> roleIds = new ArrayList<>();
		if (roles != null) {
			for (SysRole role : roles) {
				roleIds.add(role.getRoleId());
			}
		}
		return roleIds;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public String getUserId() {
		return this.id;
	}
}