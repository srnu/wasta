/*
 * Created on 15 Dec 2016 ( Time 17:37:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

/**
 * Persistent class for entity stored in table "t_id_qualification_master"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_qualification_master" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdQualificationMasterEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdQualificationMasterEntitySearch x" )
} )
public class TIdQualificationMasterEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="qualification_key", nullable=false)
    private Long       qualificationKey ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code", length=75)
    private String     code         ;

    @Column(name="name", length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     name         ;

    @Column(name="qualification_active_status_key")
    private Long       qualificationActiveStatusKey ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_from", nullable=false)
    private Date       activeFrom   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_to")
    private Date       activeTo     ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(fetch = FetchType.EAGER, mappedBy="tIdQualificationMaster", targetEntity=TIdEducationalInformationEntitySearch.class, cascade = CascadeType.ALL)
    private List<TIdEducationalInformationEntitySearch> listOfTIdEducationalInformation;
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdQualificationMasterEntitySearch() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setQualificationKey( Long qualificationKey ) {
        this.qualificationKey = qualificationKey ;
    }
    public Long getQualificationKey() {
        return this.qualificationKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : code ( VARCHAR ) 
    public void setCode( String code ) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : qualification_active_status_key ( BIGINT ) 
    public void setQualificationActiveStatusKey( Long qualificationActiveStatusKey ) {
        this.qualificationActiveStatusKey = qualificationActiveStatusKey;
    }
    public Long getQualificationActiveStatusKey() {
        return this.qualificationActiveStatusKey;
    }

    //--- DATABASE MAPPING : active_from ( DATETIME ) 
    public void setActiveFrom( Date activeFrom ) {
        this.activeFrom = activeFrom;
    }
    public Date getActiveFrom() {
        return this.activeFrom;
    }

    //--- DATABASE MAPPING : active_to ( DATETIME ) 
    public void setActiveTo( Date activeTo ) {
        this.activeTo = activeTo;
    }
    public Date getActiveTo() {
        return this.activeTo;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    public List<TIdEducationalInformationEntitySearch> getListOfTIdEducationalInformation() {
		return listOfTIdEducationalInformation;
	}

	public void setListOfTIdEducationalInformation(
			List<TIdEducationalInformationEntitySearch> listOfTIdEducationalInformation) {
		this.listOfTIdEducationalInformation = listOfTIdEducationalInformation;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(qualificationKey);
        sb.append("]:"); 
        sb.append(code);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(qualificationActiveStatusKey);
        sb.append("|");
        sb.append(activeFrom);
        sb.append("|");
        sb.append(activeTo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}