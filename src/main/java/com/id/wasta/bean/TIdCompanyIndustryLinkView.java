package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;



public class TIdCompanyIndustryLinkView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@NotNull
	private Long cilKey;
	
	@NotNull
	private Long cilPexKey;
	
	@NotNull
	private Long cilBusinessTypeKey;
	
	 @NotNull
    private String name;
	
	@NotNull
	private Long cilLockKey;

	public Long getCilKey() {
		return cilKey;
	}

	public void setCilKey(Long cilKey) {
		this.cilKey = cilKey;
	}

	public Long getCilPexKey() {
		return cilPexKey;
	}

	public void setCilPexKey(Long cilPexKey) {
		this.cilPexKey = cilPexKey;
	}

	public Long getCilBusinessTypeKey() {
		return cilBusinessTypeKey;
	}

	public void setCilBusinessTypeKey(Long cilBusinessTypeKey) {
		this.cilBusinessTypeKey = cilBusinessTypeKey;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCilLockKey() {
		return cilLockKey;
	}

	public void setCilLockKey(Long cilLockKey) {
		this.cilLockKey = cilLockKey;
	}
	
	


}
