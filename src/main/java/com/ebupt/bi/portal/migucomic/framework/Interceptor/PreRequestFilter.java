package com.ebupt.bi.portal.migucomic.framework.Interceptor;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;

@PreMatching  //不知道为什么和后请求过滤器冲突,不能同时使用
public class PreRequestFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        /**
         * 具体可以获取什么参数,加个断点就可以看到了
         */
        System.out.println("PreRequestFilter");
    }
}