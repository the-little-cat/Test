package com.ebupt.bi.portal.jersey;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PortalApplication extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(PortalApplication.class);
	 public PortalApplication() {
        property("jersey.config.server.mvc.templateBasePath.jsp", "/jsp");
        // MVC.  
        register(JspMvcFeature.class);  
        register(RequestContextFilter.class);
	 	register(MultiPartFeature.class);
    }
}
