/*
 * YOUI框架
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gsoft.mon.sys.entity;

import java.util.Collection;
import java.util.List;

import com.gsoft.framework.security.AbstractFormUserInfo;

/**
 * UserAccount
 * @author liupeng
 *
 */
public class SysUserAccount extends AbstractFormUserInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3476455557036682784L;
	
	protected String username;
	
	private List<String> permissions;
	
	/**
	 * 
	 * @param user
	 */
	public SysUserAccount(SysUser user) {
		super(user, user.getPassword());
		this.username = user.getLoginName();
	}
	
	/** 
	 * 创建一个新的实例 SysUserAccount.  
	 * 
	 */
	public SysUserAccount(SysUser user,Object credentials) {
		super(user, credentials);
		this.username = user.getLoginName();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public Collection<String> getStringPermissions() {
		return permissions;
	}
}
