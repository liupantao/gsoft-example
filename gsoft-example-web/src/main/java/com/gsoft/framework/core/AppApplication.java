package com.gsoft.framework.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gsoft.framework.context.annotation.ModuleScan;
import com.gsoft.framework.webcontext.autoconfigure.WebUiConfig;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * 启动
 * 
 * @author LiuPeng
 *
 */
@SpringBootApplication(exclude = { WebUiConfig.class })
@ModuleScan()
public class AppApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public ShiroDialect shiroDialect(){
		return new ShiroDialect();
	}
	
}