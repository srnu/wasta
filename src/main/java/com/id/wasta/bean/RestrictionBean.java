package com.id.wasta.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.id.wasta.bean.jpa.TIdCategoryMasterEntity;
import com.id.wasta.bean.jpa.TIdUserMasterViewSearchEntity;

@JsonInclude(Include.NON_EMPTY)
public class RestrictionBean {

	private static final long serialVersionUID = 1L;
	
	private Allow allow;
	private List<Fields> fields;

	public void setAllow(Allow allow) {
		this.allow = allow;
	}

	public Allow getAllow() {
		return allow;
	}

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "RestrictionBean [allow=" + allow + "]";
	}

	public static class Allow {

		private boolean alluser;
		private List<Long> category;
		private List<Long> users;
		private List<TIdCategoryMasterEntity> categoryList;
		private List<TIdUserMasterViewSearchEntity> userList;
		 
		public void setAlluser(boolean alluser) {
			this.alluser = alluser;
		}

		public boolean getAlluser() {
			return alluser;
		}

		public void setCategory(List<Long> category) {
			this.category = category;
		}

		public List<Long> getCategory() {
			return category;
		}

		public void setUsers(List<Long> users) {
			this.users = users;
		}

		public List<Long> getUsers() {
			return users;
		}
		
		public List<TIdCategoryMasterEntity> getCategoryList() {
			return categoryList;
		}
		public void setCategoryList(List<TIdCategoryMasterEntity> categoryList) {
			this.categoryList = categoryList;
		}
		
		public List<TIdUserMasterViewSearchEntity> getUserList() {
			return userList;
		}
		public void setUserList(List<TIdUserMasterViewSearchEntity> userList) {
			this.userList = userList;
		}

		@Override
		public String toString() {
			return "Allow [alluser=" + alluser + ", category=" + category
					+ ", users=" + users + "]";
		}

	}

	public static class Fields {

	    private String value;
	    private Allow allow;
	    private List<Long> allow2;
	    public void setValue(String value) {
	         this.value = value;
	     }
	     public String getValue() {
	         return value;
	     }

	    public void setAllow(Allow allow) {
	         this.allow = allow;
	     }
	     public Allow getAllow() {
	         return allow;
	     }
		public List<Long> getAllow2() {
			return allow2;
		}
		public void setAllow2(List<Long> allow2) {
			this.allow2 = allow2;
		}
	     
	     

	}
	
	/*public static class Field
	{
		private Fields field;

		public Fields getField() {
			return field;
		}

		public void setField(Fields field) {
			this.field = field;
		}
		
	}*/

	

}
