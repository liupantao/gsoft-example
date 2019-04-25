/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */

package com.gsoft.mon.sys.provide.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.gsoft.framework.codemap.service.ConvertManager;
import com.gsoft.framework.core.convert.IConvert;
import com.gsoft.framework.core.dataobj.Record;
import com.gsoft.mon.sys.provide.SysConvertService;

/**
 * 数据字典微服务
 * @author liupeng
 * @date 2018年5月16日
 *  
 */
@Service
public class SysConvertServiceImpl implements SysConvertService {

	@Autowired(required=false)
	private ConvertManager convertManager;
	
	@Override
	public void refreshCached(String name) {
		convertManager.refreshCached(name);
	}

	@Override
	public IConvert<?> getConvert(String name) {
		return convertManager.getConvert(name);
	}

	@Override
	public Record getConverts(List<String> names) {
		return convertManager.getConverts(names);
	}

}
