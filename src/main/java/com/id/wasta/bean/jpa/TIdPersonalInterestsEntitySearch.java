
/*
 * Created on 20 Feb 2017 ( Time 18:45:12 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
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
import javax.persistence.Version;

import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Persistent class for entity stored in table "t_id_personal_interests"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_personal_interests")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdPersonalInterestsEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdPersonalInterestsEntitySearch x" )
} )
public class TIdPersonalInterestsEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="peri_key", nullable=false)
    private Long       key      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    @Column(name="peri_others", length=75)
		
     private String     periOthers   ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;
    
    @Column(name="peri_created_by", length=20)
    private Long periCreatedBy;


    @ManyToOne
    @JoinColumn(name="peri_pin_key", referencedColumnName="pin_key")
    private TIdPersonalInformationEntitySearch tIdPersonalInformation;
    
    @IndexedEmbedded
	@ManyToOne
    @JoinColumn(name="peri_skill_key", referencedColumnName="skill_key")
    private TIdSkillMasterEntitySearch tIdSkillMaster;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdPersonalInterestsEntitySearch() {
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
   

    //--- DATABASE MAPPING : peri_others ( VARCHAR ) 
    public void setPeriOthers( String periOthers ) {
        this.periOthers = periOthers;
    }
    public String getPeriOthers() {
        return this.periOthers;
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

    public TIdPersonalInformationEntitySearch gettIdPersonalInformation() {
		return tIdPersonalInformation;
	}

	public void settIdPersonalInformation(TIdPersonalInformationEntitySearch tIdPersonalInformation) {
		this.tIdPersonalInformation = tIdPersonalInformation;
	}

	public TIdSkillMasterEntitySearch gettIdSkillMaster() {
		return tIdSkillMaster;
	}

	public void settIdSkillMaster(TIdSkillMasterEntitySearch tIdSkillMaster) {
		this.tIdSkillMaster = tIdSkillMaster;
	}
	
	

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    public long getPeriCreatedBy() {
		return periCreatedBy;
	}

	public void setPeriCreatedBy(long periCreatedBy) {
		this.periCreatedBy = periCreatedBy;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(key);
        sb.append("]:"); 
        sb.append(periOthers);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(periCreatedBy);
        return sb.toString(); 
    } 

}