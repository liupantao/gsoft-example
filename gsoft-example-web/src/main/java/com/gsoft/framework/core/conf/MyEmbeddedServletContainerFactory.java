package com.gsoft.framework.core.conf;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

@Component
public class MyEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
	
	@Value("${server.port}")
	private int port;

	@Value("${server.tomcat.maxConnections:2000}")
	private int maxConnections;

	@Value("${server.tomcat.maxThreads:2000}")
	private int maxThreads;

	@Value("${server.tomcat.connectionTimeout:30000}")
	private int connectionTimeout;
	
	public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {
		// 设置端口
		this.setPort(port);
		return super.getEmbeddedServletContainer(initializers);
	}

	protected void customizeConnector(Connector connector) {
		super.customizeConnector(connector);
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		// 设置最大连接数
		protocol.setMaxConnections(maxConnections);
		// 设置最大线程数
		protocol.setMaxThreads(maxThreads);
		protocol.setConnectionTimeout(connectionTimeout);
	}
}