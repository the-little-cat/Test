package com.ebupt.bi.portal.dongxin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.hibernate.annotations.Parameter;
import org.springframework.security.access.event.PublicInvocationEvent;

import com.ebupt.appframe.entityframe.pojo.annotations.EntityId;
import com.ebupt.appframe.entityframe.pojo.annotations.MethodPersistType;
import com.ebupt.appframe.entityframe.pojo.annotations.ProxyMethod;
import com.ebupt.appframe.entityframe.pojo.entitybuilder.EntityBuilderNoInterface;
import com.ebupt.appframe.entityframe.utils.DaoFactory;
import com.ebupt.appframe.entityframe.utils.EntityRoot;
import com.ebupt.bi.portal.entity.TestTable;
import com.ebupt.bi.portal.entity.TestTable.TestTableBuilder;

import antlr.collections.List;


@Entity
@Table(name="resource_dongxin")
public class resource_dongxin implements EntityRoot{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EntityId
	@Column(length=20, nullable=false)
	private int id;
	
	@Column(length=20)
    private String name;
	@Column(length=45)
    private String dec;
    
    
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDec() {
		return dec;
	}
	
	@ProxyMethod(persistType=MethodPersistType.UPDATE)
	public void Update(String name,String dec){
		this.name=name;
		this.dec=dec;
		
	}
	
	@ProxyMethod(persistType=MethodPersistType.DELETE)
	public void delete(){}
	
	
	//@ProxyMethod(persistType=MethodPersistType.READ)
	//public List read(){
	//	List res=(List) DaoFactory.getDao(resource_dongxin.class).getAll();
	//	System.out.println(res);
	//	return res;
	//}
	
    
	
	public static resource_dongxinBuilde getBuilder() {
		return new resource_dongxinBuilde();
	}

	public static class resource_dongxinBuilde extends EntityBuilderNoInterface<resource_dongxin> {
		private resource_dongxin User;

		public resource_dongxinBuilde() {
			User = new resource_dongxin();
		}

		public resource_dongxinBuilde setId(Integer id) {
			this.User.id = id;
			return this;
		}

		public resource_dongxinBuilde setName(String name) {
			this.User.name = name;
			return this;
		}

		public resource_dongxinBuilde setDec(String Des) {
			this.User.dec = Des;
			return this;
		}


		@Override
		protected resource_dongxin doBuild() {
			return User;
		}
	}

}
