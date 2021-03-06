/*
 * Created on 17 Nov 2016 ( Time 19:54:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

/**
 * Persistent class for entity stored in table "t_id_designation_master"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_designation_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdDesignationMasterEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdDesignationMasterEntitySearch x" )
} )
public class TIdDesignationMasterEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="desig_key", nullable=false)
    private Long       key          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code", nullable=false, length=75)
    private String     code         ;

    @Column(name="name", nullable=false, length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     name         ;

    @Column(name="desig_active_flag", nullable=false)
    private Long       desigActiveFlag ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_from")
    private Date       activeFrom   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_to")
    private Date       activeTo     ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Version
    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="tIdDesignationMaster", targetEntity=TIdExperienceInformationEntitySearch.class)
    private List<TIdExperienceInformationEntitySearch> listOfTIdExperienceInformation;


    /*@OneToMany(mappedBy="tIdDesignationMaster", targetEntity=TIdAwardsInformationEntitySearch.class)
    private List<TIdAwardsInformationEntitySearch> listOfTIdAwardsInformation;*/
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdDesignationMasterEntitySearch() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setKey( Long key ) {
        this.key = key ;
    }
    public Long getKey() {
        return this.key;
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

    //--- DATABASE MAPPING : desig_active_flag ( BIGINT ) 
    public void setDesigActiveFlag( Long desigActiveFlag ) {
        this.desigActiveFlag = desigActiveFlag;
    }
    public Long getDesigActiveFlag() {
        return this.desigActiveFlag;
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

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfTIdExperienceInformation( List<TIdExperienceInformationEntitySearch> listOfTIdExperienceInformation ) {
        this.listOfTIdExperienceInformation = listOfTIdExperienceInformation;
    }
    public List<TIdExperienceInformationEntitySearch> getListOfTIdExperienceInformation() {
        return this.listOfTIdExperienceInformation;
    }


    /*public List<TIdAwardsInformationEntitySearch> getListOfTIdAwardsInformation() {
		return listOfTIdAwardsInformation;
	}

	public void setListOfTIdAwardsInformation(List<TIdAwardsInformationEntitySearch> listOfTIdAwardsInformation) {
		this.listOfTIdAwardsInformation = listOfTIdAwardsInformation;
	}*/

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
        sb.append(code);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(desigActiveFlag);
        sb.append("|");
        sb.append(activeFrom);
        sb.append("|");
        sb.append(activeTo);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        return sb.toString(); 
    } 

}
