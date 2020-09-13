package com.id.wasta.bean;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TIdCompanyIndustryLinkSearch implements Serializable {

	 	private static final long serialVersionUID = 1L;
	 
	    /*@NotNull
		private Long cilKey;*/
		
		//private TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch;
	
		private TIdBusinessTypeMasterSearch tIdBusinessTypeMasterSearch;
		
		@NotNull
		/*private Long cilLockKey;*/

		/*public Long getCilKey() {
			return cilKey;
		}

		public void setCilKey(Long cilKey) {
			this.cilKey = cilKey;
		}

		public Long getCilLockKey() {
			return cilLockKey;
		}

		public void setCilLockKey(Long cilLockKey) {
			this.cilLockKey = cilLockKey;
		}*/
		
		public TIdBusinessTypeMasterSearch gettIdBusinessTypeMasterSearch() {
			return tIdBusinessTypeMasterSearch;
		}

		public void settIdBusinessTypeMasterSearch(
				TIdBusinessTypeMasterSearch tIdBusinessTypeMasterSearch) {
			this.tIdBusinessTypeMasterSearch = tIdBusinessTypeMasterSearch;
		}
		
}
