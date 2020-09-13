package com.id.wasta.bean;

import java.io.Serializable;

import com.id.wasta.bean.jpa.TIdExperienceInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;

public class TIdPersonalInfoLinkSearch implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long pilKey;

	private String pilCurrentlyWorking;
	
	private TIdPersonalInformationEntitySearch tIdPersonalInformation;
	 
	private TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch;

	public Long getPilKey() {
		return pilKey;
	}

	public void setPilKey(Long pilKey) {
		this.pilKey = pilKey;
	}

	public String getPilCurrentlyWorking() {
		return pilCurrentlyWorking;
	}

	public void setPilCurrentlyWorking(String pilCurrentlyWorking) {
		this.pilCurrentlyWorking = pilCurrentlyWorking;
	}

	public TIdPersonalInformationEntitySearch gettIdPersonalInformation() {
		return tIdPersonalInformation;
	}

	public void settIdPersonalInformation(
			TIdPersonalInformationEntitySearch tIdPersonalInformation) {
		this.tIdPersonalInformation = tIdPersonalInformation;
	}

	public TIdExperienceInformationEntitySearch gettIdExperienceInformationEntitySearch() {
		return tIdExperienceInformationEntitySearch;
	}

	public void settIdExperienceInformationEntitySearch(
			TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch) {
		this.tIdExperienceInformationEntitySearch = tIdExperienceInformationEntitySearch;
	}
	
	    
}
