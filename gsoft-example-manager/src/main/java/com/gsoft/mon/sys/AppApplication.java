/*
 * Gsoft开发框架
 * Copyright 2015-2020 the original author or authors.
 */
package com.gsoft.mon.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gsoft.framework.context.annotation.ModuleScan;
import com.gsoft.framework.jpa.repository.EnableJpaDaos;
import com.gsoft.framework.webcontext.autoconfigure.WebUiConfig;

/**
 * 启动
 * @author LiuPeng
 *
 */
@SpringBootApplication(exclude = { WebUiConfig.class })
@ModuleScan
@EnableJpaDaos
public class AppApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppApplication.class, args);
	}

}