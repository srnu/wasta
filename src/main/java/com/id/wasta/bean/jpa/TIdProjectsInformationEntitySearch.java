
/*
 * Created on 8 Dec 2016 ( Time 10:40:25 )
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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 * Persistent class for entity stored in table "t_id_projects_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_projects_information")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProjectsInformationEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdProjectsInformationEntitySearch x" )
} )
public class TIdProjectsInformationEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pip_key", nullable=false)
    private Long       pipKey       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="pip_project_name", nullable=false, length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     pipProjectName ;

   /* @Column(name="pip_company_cms_key")
		
     private Long       pipCompanyCmsKey ;
*/
    /*@Column(name="pip_company_name", length=240)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     pipCompanyName ;*/

    @Column(name="pip_from_month", length=3)
		
     private String     pipFromMonth ;

    @Column(name="pip_from_year")
		
     private Long       pipFromYear  ;

    @Column(name="pip_to_month", length=3)
		
     private String     pipToMonth   ;

    @Column(name="pip_to_year")
		
     private Long       pipToYear    ;

    @Column(name="pip_years")
		
     private String       pipYears     ;

    @Column(name="pip_description", length=1000)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
     private String     pipDescription ;

    @Column(name="active_status", nullable=false, length=75)
		
     private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
				@Version
		
     private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
		
     private Long       profileKey   ;
    
    
    @Column(name="pip_created_by",length=20)
    private Long pipCreatedBy;

	// "pipPinKey" (column "pip_pin_key") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="pip_pin_key", referencedColumnName="pin_key")
    private TIdPersonalInformationEntitySearch tIdPersonalInformation;

    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pip_company_cms_key", referencedColumnName="company_key")
    private TIdCompanyMasterEntitySearch tIdCompanyMaster;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdProjectsInformationEntitySearch() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPipKey( Long pipKey ) {
        this.pipKey = pipKey ;
    }
    public Long getPipKey() {
        return this.pipKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pip_project_name ( VARCHAR ) 
    public void setPipProjectName( String pipProjectName ) {
        this.pipProjectName = pipProjectName;
    }
    public String getPipProjectName() {
        return this.pipProjectName;
    }

   /* //--- DATABASE MAPPING : pip_company_cms_key ( BIGINT ) 
    public void setPipCompanyCmsKey( Long pipCompanyCmsKey ) {
        this.pipCompanyCmsKey = pipCompanyCmsKey;
    }
    public Long getPipCompanyCmsKey() {
        return this.pipCompanyCmsKey;
    }
*/
    //--- DATABASE MAPPING : pip_company_name ( VARCHAR ) 
    /*public void setPipCompanyName( String pipCompanyName ) {
        this.pipCompanyName = pipCompanyName;
    }
    public String getPipCompanyName() {
        return this.pipCompanyName;
    }*/

    //--- DATABASE MAPPING : pip_from_month ( VARCHAR ) 
    public void setPipFromMonth( String pipFromMonth ) {
        this.pipFromMonth = pipFromMonth;
    }
    public String getPipFromMonth() {
        return this.pipFromMonth;
    }

    //--- DATABASE MAPPING : pip_from_year ( BIGINT ) 
    public void setPipFromYear( Long pipFromYear ) {
        this.pipFromYear = pipFromYear;
    }
    public Long getPipFromYear() {
        return this.pipFromYear;
    }

    //--- DATABASE MAPPING : pip_to_month ( VARCHAR ) 
    public void setPipToMonth( String pipToMonth ) {
        this.pipToMonth = pipToMonth;
    }
    public String getPipToMonth() {
        return this.pipToMonth;
    }

    //--- DATABASE MAPPING : pip_to_year ( BIGINT ) 
    public void setPipToYear( Long pipToYear ) {
        this.pipToYear = pipToYear;
    }
    public Long getPipToYear() {
        return this.pipToYear;
    }

    //--- DATABASE MAPPING : pip_years ( BIGINT ) 
    public void setPipYears( String pipYears ) {
        this.pipYears = pipYears;
    }
    public String getPipYears() {
        return this.pipYears;
    }

    //--- DATABASE MAPPING : pip_description ( VARCHAR ) 
    public void setPipDescription( String pipDescription ) {
        this.pipDescription = pipDescription;
    }
    public String getPipDescription() {
        return this.pipDescription;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTIdPersonalInformation( TIdPersonalInformationEntitySearch tIdPersonalInformation ) {
        this.tIdPersonalInformation = tIdPersonalInformation;
    }
    public TIdPersonalInformationEntitySearch getTIdPersonalInformation() {
        return this.tIdPersonalInformation;
    }


    public TIdCompanyMasterEntitySearch getTIdCompanyMaster() {
		return tIdCompanyMaster;
	}

	public void setTIdCompanyMaster(TIdCompanyMasterEntitySearch tIdCompanyMaster) {
		this.tIdCompanyMaster = tIdCompanyMaster;
	}
	
	
	

	public Long getPipCreatedBy() {
		return pipCreatedBy;
	}

	public void setPipCreatedBy(Long pipCreatedBy) {
		this.pipCreatedBy = pipCreatedBy;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pipKey);
        sb.append("]:"); 
        sb.append(pipProjectName);
       /* sb.append("|");
        sb.append(pipCompanyCmsKey);*/
        sb.append("|");
        sb.append(pipFromMonth);
        sb.append("|");
        sb.append(pipFromYear);
        sb.append("|");
        sb.append(pipToMonth);
        sb.append("|");
        sb.append(pipToYear);
        sb.append("|");
        sb.append(pipYears);
        sb.append("|");
        sb.append(pipDescription);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(pipCreatedBy);
        
        
        return sb.toString(); 
    } 

}
