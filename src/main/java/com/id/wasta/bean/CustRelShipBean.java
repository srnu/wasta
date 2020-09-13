package com.id.wasta.bean;

import java.io.Serializable;

/**
 * @author sivachandra.k
 *
 */
public class CustRelShipBean implements Serializable {

	private static final long serialVersionUID = 1L;

		private Long primaryKey;
		private Long groupCmKey;
		private String groupCmName;
		private Long corpRelationKey;
		private String corpRelationName;
		private Long userPinKey;
		private Long lockKey;
		
		public Long getPrimaryKey() {
			return primaryKey;
		}
		public void setPrimaryKey(Long primaryKey) {
			this.primaryKey = primaryKey;
		}
		public Long getGroupCmKey() {
			return groupCmKey;
		}
		public void setGroupCmKey(Long groupCmKey) {
			this.groupCmKey = groupCmKey;
		}
		public String getGroupCmName() {
			return groupCmName;
		}
		public void setGroupCmName(String groupCmName) {
			this.groupCmName = groupCmName;
		}
		public Long getCorpRelationKey() {
			return corpRelationKey;
		}
		public void setCorpRelationKey(Long corpRelationKey) {
			this.corpRelationKey = corpRelationKey;
		}
		public String getCorpRelationName() {
			return corpRelationName;
		}
		public void setCorpRelationName(String corpRelationName) {
			this.corpRelationName = corpRelationName;
		}
		public Long getUserPinKey() {
			return userPinKey;
		}
		public void setUserPinKey(Long userPinKey) {
			this.userPinKey = userPinKey;
		}
		public Long getLockKey() {
			return lockKey;
		}
		public void setLockKey(Long lockKey) {
			this.lockKey = lockKey;
		}
}
