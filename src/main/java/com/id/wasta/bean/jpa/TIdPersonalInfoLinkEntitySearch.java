/*
 * Created on 1 Nov 2016 ( Time 10:40:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Persistent class for entity stored in table "t_id_personal_info_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "t_id_personal_info_link")
@NamedQueries({ @NamedQuery(name = "TIdPersonalInfoLinkEntitySearch.countAll", query = "SELECT COUNT(x) FROM TIdPersonalInfoLinkEntitySearch x") })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdPersonalInfoLinkEntitySearch implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pil_key")
	private Long pilKey;

	@Column(name = "pil_currently_working")
	private String pilCurrentlyWorking;
	
	 @ManyToOne
	 @JoinColumn(name="pil_pin_key", referencedColumnName="pin_key")
	 @JsonBackReference
	 private TIdPersonalInformationEntitySearch tIdPersonalInformation;
	 
	 
	  @ManyToOne
	  @JoinColumn(name="pil_pex_key", referencedColumnName="pex_key")
		 @JsonBackReference
	  private TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch;
	    

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public TIdPersonalInfoLinkEntitySearch() {
		super();
	}

	public Long getPilKey() {
		return pilKey;
	}

	public void setPilKey(Long pilKey) {
		this.pilKey = pilKey;
	}
	
	/*public Long getPilPinKey() {
		return pilPinKey;
	}

	public void setPilPinKey(Long pilPinKey) {
		this.pilPinKey = pilPinKey;
	}*/
	

	
	public TIdPersonalInformationEntitySearch gettIdPersonalInformation() {
		return tIdPersonalInformation;
	}

	public TIdExperienceInformationEntitySearch gettIdExperienceInformationEntitySearch() {
		return tIdExperienceInformationEntitySearch;
	}

	public void settIdExperienceInformationEntitySearch(
			TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch) {
		this.tIdExperienceInformationEntitySearch = tIdExperienceInformationEntitySearch;
	}

	public void settIdPersonalInformation(
			TIdPersonalInformationEntitySearch tIdPersonalInformation) {
		this.tIdPersonalInformation = tIdPersonalInformation;
	}
	
	public String getPilCurrentlyWorking() {
		return pilCurrentlyWorking;
	}

	public void setPilCurrentlyWorking(String pilCurrentlyWorking) {
		this.pilCurrentlyWorking = pilCurrentlyWorking;
	}

}
