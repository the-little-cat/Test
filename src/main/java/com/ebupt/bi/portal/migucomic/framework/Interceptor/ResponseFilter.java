package com.ebupt.bi.portal.migucomic.framework.Interceptor;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext,
                       ContainerResponseContext containerResponseContext) throws IOException {
        /**
         * 具体可以获取什么参数,加个断点就可以看到了
         */
    	
    	
    	
        System.out.println("执行回复过滤");
    }
}