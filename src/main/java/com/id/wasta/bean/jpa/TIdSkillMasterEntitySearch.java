
/*
 * Created on 20 Feb 2017 ( Time 14:33:02 )
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.id.util.data.repository.jpa.validators.constraints.Unique;
import com.id.wasta.util.action.CommonConstants;

/**
 * Persistent class for entity stored in table "t_id_skill_master"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_skill_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdSkillMasterEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdSkillMasterEntitySearch x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdSkillMasterEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="skill_key", nullable=false)
    private Long       key          ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code", length=75)
		
     private String     code         ;

    @Column(name="name", nullable=false, length=240)
    @Unique(property = "name", tableName = "TIdSkillMasterEntity", message="skill.name.already.exists")
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     name         ;

    @Column(name="skill_active_status_key", nullable=false)
		
     private Long       skillActiveStatusKey ;

    @Column(name="skill_category", length=200)
		
     private Long     skillCategory ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_from", nullable=false)
		
     private Date       activeFrom   ;

@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_to")
		
     private Date       activeTo     ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="tIdSkillMaster", targetEntity=TIdProfessionalExpertiseEntitySearch.class)
    private List<TIdProfessionalExpertiseEntitySearch> listOfTIdTIdProfessionalExpertise;
    
    @OneToMany(mappedBy="tIdSkillMaster", targetEntity=TIdProfessionalInterestsEntitySearch.class)
    private List<TIdProfessionalInterestsEntitySearch> listOfTIdProfessionalInterests;
    
    @OneToMany(mappedBy="tIdSkillMaster", targetEntity=TIdPersonalInterestsEntitySearch.class)
    private List<TIdPersonalInterestsEntitySearch> listOfTIdPersonalInterests;
    
    @OneToMany(mappedBy="tIdSkillMaster", targetEntity=TIdBusinessPotentialInfoEntitySearch.class)
    private List<TIdBusinessPotentialInfoEntitySearch> listOfTIdBusinessPotentialInfo;
    
    @OneToMany(mappedBy="tIdSkillMaster", targetEntity=TIdAddPotentialServicesEntitySearch.class)
    private List<TIdAddPotentialServicesEntitySearch> listOfTIdAddPotentialServices;


	//----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdSkillMasterEntitySearch() {
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

    //--- DATABASE MAPPING : skill_active_status_key ( BIGINT ) 
    public void setSkillActiveStatusKey( Long skillActiveStatusKey ) {
        this.skillActiveStatusKey = skillActiveStatusKey;
    }
    public Long getSkillActiveStatusKey() {
        return this.skillActiveStatusKey;
    }

    //--- DATABASE MAPPING : skill_category ( VARCHAR ) 
    public void setSkillCategory( Long skillCategory ) {
        this.skillCategory = skillCategory;
    }
    public Long getSkillCategory() {
        return this.skillCategory;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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
    public List<TIdProfessionalExpertiseEntitySearch> getListOfTIdTIdProfessionalExpertise() {
		return listOfTIdTIdProfessionalExpertise;
	}

	public void setListOfTIdTIdProfessionalExpertise(
			List<TIdProfessionalExpertiseEntitySearch> listOfTIdTIdProfessionalExpertise) {
		this.listOfTIdTIdProfessionalExpertise = listOfTIdTIdProfessionalExpertise;
	}

	public List<TIdProfessionalInterestsEntitySearch> getListOfTIdProfessionalInterests() {
		return listOfTIdProfessionalInterests;
	}

	public void setListOfTIdProfessionalInterests(
			List<TIdProfessionalInterestsEntitySearch> listOfTIdProfessionalInterests) {
		this.listOfTIdProfessionalInterests = listOfTIdProfessionalInterests;
	}

	public List<TIdPersonalInterestsEntitySearch> getListOfTIdPersonalInterests() {
		return listOfTIdPersonalInterests;
	}

	public void setListOfTIdPersonalInterests(List<TIdPersonalInterestsEntitySearch> listOfTIdPersonalInterests) {
		this.listOfTIdPersonalInterests = listOfTIdPersonalInterests;
	}
	
	public List<TIdBusinessPotentialInfoEntitySearch> getListOfTIdBusinessPotentialInfo() {
		return listOfTIdBusinessPotentialInfo;
	}

	public void setListOfTIdBusinessPotentialInfo(
			List<TIdBusinessPotentialInfoEntitySearch> listOfTIdBusinessPotentialInfo) {
		this.listOfTIdBusinessPotentialInfo = listOfTIdBusinessPotentialInfo;
	}
	
	public List<TIdAddPotentialServicesEntitySearch> getListOfTIdAddPotentialServices() {
		return listOfTIdAddPotentialServices;
	}

	public void setListOfTIdAddPotentialServices(List<TIdAddPotentialServicesEntitySearch> listOfTIdAddPotentialServices) {
		this.listOfTIdAddPotentialServices = listOfTIdAddPotentialServices;
	}
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

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
        sb.append(skillActiveStatusKey);
        sb.append("|");
        sb.append(skillCategory);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(activeFrom);
        sb.append("|");
        sb.append(activeTo);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}