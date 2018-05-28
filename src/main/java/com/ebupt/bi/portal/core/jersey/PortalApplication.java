/*package com.ebupt.bi.portal.core.jersey;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebupt.bi.portal.api.support.PropertyManager;
import com.ebupt.bi.portal.api.support.entity.SystemParamInfo;
import com.ebupt.bi.portal.core.encrypt.rest.EncryptResource;
import com.ebupt.bi.portal.core.module.ModuleManager;
import com.ebupt.bi.portal.core.module.rest.ComponentResource;
import com.ebupt.bi.portal.core.ui.rest.NavigationResource;
import com.ebupt.bi.portal.migucomic.framework.Interceptor.GzipInterceptor;
import com.ebupt.bi.portal.migucomic.framework.Interceptor.PreRequestFilter;
import com.ebupt.bi.portal.migucomic.framework.Interceptor.ResponseFilter;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component
public class PortalApplication extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(PortalApplication.class);
	@Autowired
	private PropertyManager propertyManager;
	@Autowired
	private ModuleManager moduleManager;

	@PostConstruct
	public void init() {
		initProperties();
		registJersyProviderPackages();
		registComponents();
		
		 packages("com.ebupt.bi.portal.migucomic","com.ebupt.bi.portal.migucomic");
	        register(LoggingFilter.class);
	        register(JacksonJsonProvider.class);
	        //注册过滤器,扫包对@PreMatching注解无用,只能手动加入
	        register(PreRequestFilter.class);
	        register(ResponseFilter.class);
	        *//**
	         * 对于链接,先执行请求过滤,有异常则执行异常过滤,最后执行回复过滤
	         *//*
	        System.out.println("加载RESTApplication");
	        register(GzipInterceptor.class);

	}

	private void initProperties() {
		if (propertyManager == null)
			return;
		Set<SystemParamInfo> params = propertyManager.getByPrefix("jersey.config.server");
		params.forEach(param -> property(param.getKey(), param.getValue()));

	}

	private void registComponents() {
		Set<Class<?>> components = new HashSet<>();
		components.add(RequestContextFilter.class);
		components.add(MultiPartFeature.class);
		components.add(CharsetResponseFilter.class);
		components.addAll(moduleManager.getModuleJerseyComponents());
		components.forEach(component -> register(component));
	}

	private void registJersyProviderPackages() {
		Set<String> jerseyPackageConf = new HashSet<>();
		jerseyPackageConf.addAll(moduleManager.getModuleJerseyPackages());
		jerseyPackageConf.add(ComponentResource.class.getPackage().getName());
		jerseyPackageConf.add(NavigationResource.class.getPackage().getName());
		jerseyPackageConf.add(EncryptResource.class.getPackage().getName());
		final StringBuffer jerseyPackageConfStr = new StringBuffer();
		jerseyPackageConf.forEach(packageName -> jerseyPackageConfStr.append(packageName).append(","));
		jerseyPackageConfStr.deleteCharAt(jerseyPackageConfStr.length() - 1);
		logger.info("jersey.config.server.provider.packages[" + jerseyPackageConfStr.toString() + "]");
		property("jersey.config.server.provider.packages", jerseyPackageConfStr.toString());
	}
}
*/