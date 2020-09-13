package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_company_industry_link")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdCompanyIndustryLinkEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cil_key",nullable=false)
	private Long cilKey;
	
	@Column(name="cil_pex_key",nullable=false)
	private Long cilPexKey;
	
	@Column(name="cil_business_type_key",nullable=false)
	private Long cilBusinessTypeKey;
	
	@Column(name="cil_lock_key",nullable=false)
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

	public Long getCilLockKey() {
		return cilLockKey;
	}

	public void setCilLockKey(Long cilLockKey) {
		this.cilLockKey = cilLockKey;
	}
	
	

}
