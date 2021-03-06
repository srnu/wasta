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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Persistent class for entity stored in table "t_id_personal_info_link"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "t_id_personal_info_link")
@NamedQueries({ @NamedQuery(name = "TIdPersonalInfoLinkEntity.countAll", query = "SELECT COUNT(x) FROM TIdPersonalInfoLinkEntity x") })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdPersonalInfoLinkEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pil_key")
	private Long pilKey;

	@Column(name = "pil_pin_key")
	private Long pilPinKey;

	@Column(name = "pil_pex_key")
	private Long pilPexKey;

	@Column(name = "pil_currently_working")
	private String pilCurrentlyWorking;

	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public TIdPersonalInfoLinkEntity() {
		super();
	}

	public Long getPilKey() {
		return pilKey;
	}

	public void setPilKey(Long pilKey) {
		this.pilKey = pilKey;
	}

	public Long getPilPinKey() {
		return pilPinKey;
	}

	public void setPilPinKey(Long pilPinKey) {
		this.pilPinKey = pilPinKey;
	}

	public Long getPilPexKey() {
		return pilPexKey;
	}

	public void setPilPexKey(Long pilPexKey) {
		this.pilPexKey = pilPexKey;
	}

	public String getPilCurrentlyWorking() {
		return pilCurrentlyWorking;
	}

	public void setPilCurrentlyWorking(String pilCurrentlyWorking) {
		this.pilCurrentlyWorking = pilCurrentlyWorking;
	}

}
