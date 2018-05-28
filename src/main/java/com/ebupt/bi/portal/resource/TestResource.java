package com.ebupt.bi.portal.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ebupt.appframe.entityframe.utils.DaoFactory;
import com.ebupt.bi.portal.entity.TestTable;

/**
 * 测试类
 * 
 * @author LL
 *
 */
@Component
@Path("/test")
public class TestResource {
	private static final Logger logger = LoggerFactory.getLogger(TestResource.class);
	
	/**
	 * 查询方法
	 * http://127.0.0.1:8080/rest/test/3
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestTable get(@PathParam("id") Integer id) {
		logger.info("get");
		TestTable tt = DaoFactory.getDao(TestTable.class).get(id);
		return tt;
	}
	
	/**
	 * 删除方法
	 * http://127.0.0.1:8080/rest/test/delete/3
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/delete/{id}")
	public String delete(@PathParam("id") Integer id) {
		logger.info("delete");
		TestTable tt = DaoFactory.getDao(TestTable.class).get(id);
		tt.delete();
		return "OK";
	}

	/**
	 * 更新方法
	 * http://127.0.0.1:8080/rest/test/update/3/nameupdate
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	@GET
	@Path("/update/{id}/{name}")	
	@Produces(MediaType.APPLICATION_JSON)
	public TestTable update(@PathParam("id") Integer id, @PathParam("name") String name) {
		logger.info("update");
		TestTable tt = DaoFactory.getDao(TestTable.class).get(id);
		tt.updateName(name);
		return tt;
	}
	
	/**
	 * 创建方法
	 * http://127.0.0.1:8080/rest/test/create/name3/desc3
	 * 
	 * @param name
	 * @param desc
	 * @return
	 */
	@GET
	@Path("/create/{name}/{desc}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestTable create(@PathParam("name") String name, @PathParam("desc") String desc) {
		logger.info("create");
		TestTable tt = TestTable.getBuilder().setDemoDesc(desc).setDemoName(name).build();
		return tt;
	}
	
	
	@POST
	@Path("/test/{name}/{desc}")
	@Produces(MediaType.APPLICATION_JSON)
	public void createtest(@PathParam("name") String name, @PathParam("desc") String desc) {
		System.out.println("测试成功post");
	}
	
	@GET
	@Path("/test/{name}/{desc}")
	@Produces(MediaType.APPLICATION_JSON)
	public void createtestget(@PathParam("name") String name, @PathParam("desc") String desc) {
		System.out.println("测试成功get");
	}

}
