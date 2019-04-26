/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */

package com.gsoft.mon.sys.provide;

import java.util.List;

import com.gsoft.framework.core.convert.IConvert;
import com.gsoft.framework.core.dataobj.Record;

/**
 * 数据字典微服务
 * 
 * @author liupeng
 * @date 2018年5月16日
 * 
 */
public interface SysConvertService {

	/** 
	 * 刷新缓存
	 * @param name 
	 */
	public void refreshCached(String name);

	/** 
	 * 根据名称获取数据字典 
	 * @param name
	 * @return 
	 */
	public IConvert<?> getConvert(String name);

	/** 
	 * 根据名称集合获取数据字典集合
	 * @param names
	 * @return 
	 */
	public Record getConverts(List<String> names);

}
