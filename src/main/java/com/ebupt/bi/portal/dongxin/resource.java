package com.ebupt.bi.portal.dongxin;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ebupt.appframe.entityframe.utils.DaoFactory;

import antlr.collections.List;


@Component
@Path("/dongxin")
public class resource {
	private static final Logger logger = LoggerFactory.getLogger(resource.class);
	/*
	 http://localhost:8080/SimpleJSH/rest/dongxin/1 
    */
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public resource_dongxin get(@PathParam("id") Integer id){
		logger.info("读取数据库信息");
		resource_dongxin res=DaoFactory.getDao(resource_dongxin.class).get(id);
		//List lis= res.read();
		return res;
	}

	/*
	 http://localhost:8080/SimpleJSH/rest/dongxin/delete/1 
   */
	@GET
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") String id){
		logger.info("删除数据库数据");
		resource_dongxin res=DaoFactory.getDao(resource_dongxin.class).get(id);
		res.delete();
		
	}
	
	/*
	 http://localhost:8080/SimpleJSH/rest/dongxin/update/1/mm/mm
   */
	@GET
	@Path("/update/{id}/{name}/{dec}")
	@Produces(MediaType.APPLICATION_JSON)
	public String update(@PathParam("id") String id,@PathParam("name") String name,@PathParam("dec") String dec){
		logger.info("数据更新啦");
		resource_dongxin res=DaoFactory.getDao(resource_dongxin.class).get(id);
		res.Update(name, dec);
		return "ok";
		
	}
	
	/*
	 http://localhost:8080/SimpleJSH/rest/dongxin/create/2/nn/nn 
   */
	
	@GET
	@Path("/create/{id}/{name}/{dec}")
	@Produces(MediaType.APPLICATION_JSON)
	public  resource_dongxin create(@PathParam("id") Integer id,@PathParam("name") String name,@PathParam("dec") String dec){
		logger.info("数据创建啦");
		resource_dongxin res=resource_dongxin.getBuilder().setId(id).setName(name).setDec(dec).doBuild();
		return res;
	}


}
