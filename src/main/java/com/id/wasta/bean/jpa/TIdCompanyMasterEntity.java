
/*
 * Created on 20 Feb 2017 ( Time 14:16:15 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.id.util.data.repository.jpa.validators.constraints.Unique;
import com.id.wasta.util.action.CommonConstants;

/**
 * Persistent class for entity stored in table "t_id_company_master"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_company_master")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdCompanyMasterEntity.countAll", query="SELECT COUNT(x) FROM TIdCompanyMasterEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdCompanyMasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="company_key", nullable=false)
    private Long       key;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="code", length=75)
		
     private String     code         ;

    @Column(name="name", nullable=false, length=240)
    @Unique(property = "name", tableName = "TIdCompanyMasterEntity", message="company.name.already.exists")
     private String     name  ;
    
    @Column(name="country_key")
		
     private Long       companyCountryKey ;

    @Column(name="company_group", nullable=false, length=1)
		
     private String     companyGroup ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_from", nullable=false)
		
     private Date       activeFrom   ;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="active_to")
		
     private Date       activeTo     ;

    @Column(name="company_logo", length=200)
		
     private String     companyLogo  ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdCompanyMasterEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setKey( Long companyKey ) {
        this.key = companyKey ;
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

    //--- DATABASE MAPPING : company_country_key ( BIGINT ) 
    public void setCompanyCountryKey( Long companyCountryKey ) {
        this.companyCountryKey = companyCountryKey;
    }
    public Long getCompanyCountryKey() {
        return this.companyCountryKey;
    }

    //--- DATABASE MAPPING : company_group ( VARCHAR ) 
    public void setCompanyGroup( String companyGroup ) {
        this.companyGroup = companyGroup;
    }
    public String getCompanyGroup() {
        return this.companyGroup;
    }

    //--- DATABASE MAPPING : active_from ( DATETIME ) 
    public void setActiveFrom( Date activeFrom ) {
        this.activeFrom = activeFrom;
    }
    public Date getActiveFrom() {
        return this.activeFrom;
    }

    //--- DATABASE MAPPING : active_to ( DATE ) 
    public void setActiveTo( Date activeTo ) {
        this.activeTo = activeTo;
    }
    public Date getActiveTo() {
        return this.activeTo;
    }

    //--- DATABASE MAPPING : company_logo ( VARCHAR ) 
    public void setCompanyLogo( String companyLogo ) {
        this.companyLogo = companyLogo;
    }
    public String getCompanyLogo() {
        return this.companyLogo;
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
        sb.append(companyCountryKey);
        sb.append("|");
        sb.append(companyGroup);
        sb.append("|");
        sb.append(activeFrom);
        sb.append("|");
        sb.append(activeTo);
        sb.append("|");
        sb.append(companyLogo);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
