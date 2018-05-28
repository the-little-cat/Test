package com.ebupt.bi.portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ebupt.appframe.entityframe.pojo.annotations.EntityId;
import com.ebupt.appframe.entityframe.pojo.annotations.MethodPersistType;
import com.ebupt.appframe.entityframe.pojo.annotations.ProxyMethod;
import com.ebupt.appframe.entityframe.pojo.entitybuilder.EntityBuilderNoInterface;
import com.ebupt.appframe.entityframe.utils.EntityRoot;

/**
 * 测试实体类
 * 
 * @author LL
 *
 */
@Entity
@Table(name = "TESTTABLE")
public class TestTable implements EntityRoot {

	/**
	 * 主键序号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EntityId
	@Column(length = 10, nullable = false)
	private Integer id;
	/**
	 * 名称
	 */
	@Column(length = 20)
	private String demoName;
	/**
	 * 描述
	 */
	@Column(length = 200)
	private String demoDesc;

	/**
	 * 更新名称
	 * 
	 * @param name
	 */
	@ProxyMethod(persistType = MethodPersistType.UPDATE)
	public void updateName(String name) {
		this.demoName = name;
	}
		
	/**
	 * 删除
	 */
	@ProxyMethod(persistType = MethodPersistType.DELETE)
	public void delete() {
	}
	
	public Integer getId() {
		return id;
	}

	public String getDemoDesc() {
		return demoDesc;
	}
	
	public String getDemoName() {
		return demoName;
	}
	
	public static TestTableBuilder getBuilder() {
		return new TestTableBuilder();
	}

	public static class TestTableBuilder extends EntityBuilderNoInterface<TestTable> {
		private TestTable UserGroupInfo;

		public TestTableBuilder() {
			UserGroupInfo = new TestTable();
		}

		public TestTableBuilder setId(Integer id) {
			this.UserGroupInfo.id = id;
			return this;
		}

		public TestTableBuilder setDemoName(String demoName) {
			this.UserGroupInfo.demoName = demoName;
			return this;
		}

		public TestTableBuilder setDemoDesc(String demoDesc) {
			this.UserGroupInfo.demoDesc = demoDesc;
			return this;
		}


		@Override
		protected TestTable doBuild() {
			return UserGroupInfo;
		}

	}

}
