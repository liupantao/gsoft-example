package com.gsoft.mon.sys;

import com.gsoft.framework.context.annotation.Module;
/**
 * 模块配置
 * @author LiuPeng
 *
 */
@Module(
	name="yoreach-manager",
	caption = "系统管理",
	scanPackages={"conf", "service", "app", "job"}
)
public class ModuleConfig {
	
}
