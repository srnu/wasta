/*
 * Created on 12 Feb 2019 ( Time 18:12:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.sql.Timestamp;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Persistent class for entity stored in table "t_id_landing_business_potential"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_landing_business_potential")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdLandingBusinessPotentialEntity.countAll", query="SELECT COUNT(x) FROM TIdLandingBusinessPotentialEntity x" )
} )
public class TIdLandingBusinessPotentialEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ld_key", nullable=false)
    private Long       ldKey        ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ld_user_name", nullable=false, length=50)
    private String     ldUserName   ;

    @Column(name="ld_user_pin_key", nullable=false)
    private Long       ldUserPinKey ;

    @Column(name="ld_contact_name", nullable=false, length=50)
    private String     ldContactName ;

    @Column(name="ld_contact_pin_key", nullable=false)
    private Long       ldContactPinKey ;

    @Column(name="ld_company", nullable=false, length=50)
    private String     ldCompany    ;

    @Column(name="ld_industry", nullable=false, length=50)
    private String     ldIndustry   ;

    @Column(name="ld_country", nullable=false, length=50)
    private String     ldCountry    ;
    
    @Column(name="ld_type_change")
    private String     ldTypeChange    ;
    
    @Column(name="ld_audit_box_name")
    private String     ldAuditBoxName    ;
    
    @Column(name="ld_audit_field_name")
    private String     ldAuditFieldName    ;
    
    @Column(name="ld_audit_old_update")
    private String     ldAuditOldUpdate    ;
    
    @Column(name="ld_audit_latest_update")
    private String     ldAuditLatestUpdate    ;

    @Column(name="ld_box_name", nullable=false, length=50)
    private String     ldBoxName    ;

    @Column(name="ld_field_name", nullable=false, length=50)
    private String     ldFieldName  ;
    
    @Column(name="ld_old_update", nullable=false, length=50)
    private String     ldOldUpdate ;

    @Column(name="ld_latest_update", nullable=false, length=50)
    private String     ldLatestUpdate ;

    @Column(name="ld_update_key", nullable=false)
    private Long       ldUpdateKey  ;

    @Column(name="ld_read_flag")
    private Boolean    ldReadFlag   ;

    @Version
    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Column(name="created_on", nullable=false)
    private Timestamp       createdOn   ;

    @Column(name="ld_access_info")
    private String       ldAccessInfo   ;
    
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdLandingBusinessPotentialEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLdKey( Long ldKey ) {
        this.ldKey = ldKey ;
    }
    public Long getLdKey() {
        return this.ldKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ld_user_name ( VARCHAR ) 
    public void setLdUserName( String ldUserName ) {
        this.ldUserName = ldUserName;
    }
    public String getLdUserName() {
        return this.ldUserName;
    }

    //--- DATABASE MAPPING : ld_user_pin_key ( BIGINT ) 
    public void setLdUserPinKey( Long ldUserPinKey ) {
        this.ldUserPinKey = ldUserPinKey;
    }
    public Long getLdUserPinKey() {
        return this.ldUserPinKey;
    }

    //--- DATABASE MAPPING : ld_contact_name ( VARCHAR ) 
    public void setLdContactName( String ldContactName ) {
        this.ldContactName = ldContactName;
    }
    public String getLdContactName() {
        return this.ldContactName;
    }

    //--- DATABASE MAPPING : ld_contact_pin_key ( BIGINT ) 
    public void setLdContactPinKey( Long ldContactPinKey ) {
        this.ldContactPinKey = ldContactPinKey;
    }
    public Long getLdContactPinKey() {
        return this.ldContactPinKey;
    }

    //--- DATABASE MAPPING : ld_company ( VARCHAR ) 
    public void setLdCompany( String ldCompany ) {
        this.ldCompany = ldCompany;
    }
    public String getLdCompany() {
        return this.ldCompany;
    }

    //--- DATABASE MAPPING : ld_industry ( VARCHAR ) 
    public void setLdIndustry( String ldIndustry ) {
        this.ldIndustry = ldIndustry;
    }
    public String getLdIndustry() {
        return this.ldIndustry;
    }

    //--- DATABASE MAPPING : ld_country ( VARCHAR ) 
    public void setLdCountry( String ldCountry ) {
        this.ldCountry = ldCountry;
    }
    public String getLdCountry() {
        return this.ldCountry;
    }
    
    public String getLdTypeChange() {
		return ldTypeChange;
	}

	public void setLdTypeChange(String ldTypeChange) {
		this.ldTypeChange = ldTypeChange;
	}

	public String getLdAuditBoxName() {
		return ldAuditBoxName;
	}

	public void setLdAuditBoxName(String ldAuditBoxName) {
		this.ldAuditBoxName = ldAuditBoxName;
	}

	public String getLdAuditFieldName() {
		return ldAuditFieldName;
	}

	public void setLdAuditFieldName(String ldAuditFieldName) {
		this.ldAuditFieldName = ldAuditFieldName;
	}
	
    public String getLdAuditOldUpdate() {
		return ldAuditOldUpdate;
	}

	public void setLdAuditOldUpdate(String ldAuditOldUpdate) {
		this.ldAuditOldUpdate = ldAuditOldUpdate;
	}

	public String getLdAuditLatestUpdate() {
		return ldAuditLatestUpdate;
	}

	public void setLdAuditLatestUpdate(String ldAuditLatestUpdate) {
		this.ldAuditLatestUpdate = ldAuditLatestUpdate;
	}

    //--- DATABASE MAPPING : ld_box_name ( VARCHAR ) 
    public void setLdBoxName( String ldBoxName ) {
        this.ldBoxName = ldBoxName;
    }
    public String getLdBoxName() {
        return this.ldBoxName;
    }

    //--- DATABASE MAPPING : ld_field_name ( VARCHAR ) 
    public void setLdFieldName( String ldFieldName ) {
        this.ldFieldName = ldFieldName;
    }
    public String getLdFieldName() {
        return this.ldFieldName;
    }

    //--- DATABASE MAPPING : ld_latest_update ( VARCHAR ) 
    public void setLdLatestUpdate( String ldLatestUpdate ) {
        this.ldLatestUpdate = ldLatestUpdate;
    }
    public String getLdLatestUpdate() {
        return this.ldLatestUpdate;
    }

    //--- DATABASE MAPPING : ld_update_key ( BIGINT ) 
    public void setLdUpdateKey( Long ldUpdateKey ) {
        this.ldUpdateKey = ldUpdateKey;
    }
    public Long getLdUpdateKey() {
        return this.ldUpdateKey;
    }

    //--- DATABASE MAPPING : ld_read_flag ( BIT ) 
    public void setLdReadFlag( Boolean ldReadFlag ) {
        this.ldReadFlag = ldReadFlag;
    }
    public Boolean getLdReadFlag() {
        return this.ldReadFlag;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getLdAccessInfo() {
		return ldAccessInfo;
	}

	public void setLdAccessInfo(String ldAccessInfo) {
		this.ldAccessInfo = ldAccessInfo;
	}
	
	public String getLdOldUpdate() {
		return ldOldUpdate;
	}
	public void setLdOldUpdate(String ldOldUpdate) {
		this.ldOldUpdate = ldOldUpdate;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(ldKey);
        sb.append("]:"); 
        sb.append(ldUserName);
        sb.append("|");
        sb.append(ldUserPinKey);
        sb.append("|");
        sb.append(ldContactName);
        sb.append("|");
        sb.append(ldContactPinKey);
        sb.append("|");
        sb.append(ldCompany);
        sb.append("|");
        sb.append(ldIndustry);
        sb.append("|");
        sb.append(ldCountry);
        sb.append("|");
        sb.append(ldBoxName);
        sb.append("|");
        sb.append(ldFieldName);
        sb.append("|");
        sb.append(ldLatestUpdate);
        sb.append("|");
        sb.append(ldUpdateKey);
        sb.append("|");
        sb.append(ldReadFlag);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(createdOn);
        return sb.toString(); 
    } 

}