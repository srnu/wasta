package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.IndexedEmbedded;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_company_industry_link")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdCompanyIndustryLinkEntitySearch implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cil_key",nullable=false)
	private Long cilKey;
	
	@ManyToOne
	@JoinColumn(name="cil_pex_key",referencedColumnName="pex_key")
	private TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch;
	
	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name="cil_business_type_key",referencedColumnName="btm_key")
	private TIdBusinessTypeMasterEntitySearch tIdBusinessTypeMasterEntitySearch;
	
	
	
	@Column(name="cil_lock_key",nullable=false)
	private Long cilLockKey;
	
	public Long getCilKey() {
		return cilKey;
	}



	public void setCilKey(Long cilKey) {
		this.cilKey = cilKey;
	}



	public TIdExperienceInformationEntitySearch gettIdExperienceInformationEntitySearch() {
		return tIdExperienceInformationEntitySearch;
	}



	public void settIdExperienceInformationEntitySearch(
			TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch) {
		this.tIdExperienceInformationEntitySearch = tIdExperienceInformationEntitySearch;
	}



	public TIdBusinessTypeMasterEntitySearch gettIdBusinessTypeMasterEntitySearch() {
		return tIdBusinessTypeMasterEntitySearch;
	}



	public void settIdBusinessTypeMasterEntitySearch(
			TIdBusinessTypeMasterEntitySearch tIdBusinessTypeMasterEntitySearch) {
		this.tIdBusinessTypeMasterEntitySearch = tIdBusinessTypeMasterEntitySearch;
	}



	public Long getCilLockKey() {
		return cilLockKey;
	}



	public void setCilLockKey(Long cilLockKey) {
		this.cilLockKey = cilLockKey;
	}



	


}
