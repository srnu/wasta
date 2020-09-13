/*
 * Created on 17 Nov 2016 ( Time 19:54:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 * Persistent class for entity stored in table "t_id_experience_information"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_experience_information")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdExperienceInformationEntitySearch.countAll", query="SELECT COUNT(x) FROM TIdExperienceInformationEntitySearch x" )
} )
public class TIdExperienceInformationEntitySearch implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="pex_key", nullable=false)
    private Long       pexKey       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
   /* @Column(name="pex_city_key")
    private Long       pexCityKey   ;*/

   /* @Column(name="pex_state_key")
    private Long       pexStateKey  ;*/

   /* @Column(name="pex_country_key", nullable=false)
    private Long       pexCountryKey ;*/

    /*@Column(name="pex_role_key")
    private Long       pexRoleKey   ;*/

    @Column(name="pex_from_month", length=3)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     pexFromMonth ;

    @Column(name="pex_from_year")
    private Long       pexFromYear  ;

    @Column(name="pex_to_month", length=3)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     pexToMonth   ;

    @Column(name="pex_to_year")
    private Long       pexToYear    ;

    @Column(name="pex_experience_years")
    private String       pexExperienceYears ;

    @Column(name="pex_currently_working", length=1)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     pexCurrentlyWorking ;

    @Column(name="pex_remarks", length=2400)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String     pexRemarks   ;

    @Version
    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;
    
    
    @Column(name="pex_created_by",length=20)
    private Long pexCreatedBy;

	// "pexPinKey" (column "pex_pin_key") is not defined by itself because used as FK in a link 
	// "pexDesignationKey" (column "pex_designation_key") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_designation_key", referencedColumnName="desig_key")
    private TIdDesignationMasterEntitySearch tIdDesignationMaster;

    @ManyToOne
    @JoinColumn(name="pex_pin_key", referencedColumnName="pin_key")
    private TIdPersonalInformationEntitySearch tIdPersonalInformation;

    @IndexedEmbedded
    @OneToMany(mappedBy="tIdExperienceInformationEntitySearch",targetEntity=TIdCompanyIndustryLinkEntitySearch.class, cascade = CascadeType.ALL)
    private List<TIdCompanyIndustryLinkEntitySearch> listOfTIdCompanyIndustryLinkEntitySearch;
    
    @IndexedEmbedded
    @OneToMany(mappedBy="tIdExperienceInformationEntitySearch", targetEntity=TIdPersonalInfoLinkEntitySearch.class, cascade = CascadeType.ALL)
    private List<TIdPersonalInfoLinkEntitySearch> listOfTIdPersonalInfoLink;
    
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_company_cms_key", referencedColumnName="company_key")
    private TIdCompanyMasterEntitySearch tIdCompanyMaster;
    
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_functional_area_key", referencedColumnName="function_key")
    private TIdFunctionalAreaMasterEntitySearch tIdFunctionalAreaMaster;
    
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_role_key", referencedColumnName="rcd_detail_key")
    private TIdReferenceCodesDetailEntity tIdReferenceCodesDetail;
    
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_city_key", referencedColumnName="city_key")
    private TIdCityMasterEntitySearch tIdCityMasterSearch;
    
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_state_key", referencedColumnName="state_key")
    private TIdStateMasterEntitySearch tIdStateMasterSearch;
    
    @IndexedEmbedded
    @ManyToOne
    @JoinColumn(name="pex_country_key", referencedColumnName="country_key")
    private TIdCountryMasterEntitySearch tIdCountryMasterSearch;
    
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdExperienceInformationEntitySearch() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPexKey( Long pexKey ) {
        this.pexKey = pexKey ;
    }
    public Long getPexKey() {
        return this.pexKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pex_city_key ( BIGINT ) 
  /*  public void setPexCityKey( Long pexCityKey ) {
        this.pexCityKey = pexCityKey;
    }
    public Long getPexCityKey() {
        return this.pexCityKey;
    }*/

    //--- DATABASE MAPPING : pex_state_key ( BIGINT ) 
   /* public void setPexStateKey( Long pexStateKey ) {
        this.pexStateKey = pexStateKey;
    }
    public Long getPexStateKey() {
        return this.pexStateKey;
    }
*/
    //--- DATABASE MAPPING : pix_country_key ( BIGINT ) 
   /* public void setPexCountryKey( Long pexCountryKey ) {
        this.pexCountryKey = pexCountryKey;
    }
    public Long getPexCountryKey() {
        return this.pexCountryKey;
    }*/

    //--- DATABASE MAPPING : pex_role_key ( BIGINT ) 
    /*public void setPexRoleKey( Long pexRoleKey ) {
        this.pexRoleKey = pexRoleKey;
    }
    public Long getPexRoleKey() {
        return this.pexRoleKey;
    }*/

    //--- DATABASE MAPPING : pex_from_month ( VARCHAR ) 
    public void setPexFromMonth( String pexFromMonth ) {
        this.pexFromMonth = pexFromMonth;
    }
    public String getPexFromMonth() {
        return this.pexFromMonth;
    }

    //--- DATABASE MAPPING : pex_from_year ( BIGINT ) 
    public void setPexFromYear( Long pexFromYear ) {
        this.pexFromYear = pexFromYear;
    }
    public Long getPexFromYear() {
        return this.pexFromYear;
    }

    //--- DATABASE MAPPING : pex_to_month ( VARCHAR ) 
    public void setPexToMonth( String pexToMonth ) {
        this.pexToMonth = pexToMonth;
    }
    public String getPexToMonth() {
        return this.pexToMonth;
    }

    //--- DATABASE MAPPING : pex_to_year ( BIGINT ) 
    public void setPexToYear( Long pexToYear ) {
        this.pexToYear = pexToYear;
    }
    public Long getPexToYear() {
        return this.pexToYear;
    }

    //--- DATABASE MAPPING : pex_experience_years ( BIGINT ) 
    public void setPexExperienceYears( String pexExperienceYears ) {
        this.pexExperienceYears = pexExperienceYears;
    }
    public String getPexExperienceYears() {
        return this.pexExperienceYears;
    }

    //--- DATABASE MAPPING : pex_currently_working ( VARCHAR ) 
    public void setPexCurrentlyWorking( String pexCurrentlyWorking ) {
        this.pexCurrentlyWorking = pexCurrentlyWorking;
    }
    public String getPexCurrentlyWorking() {
        return this.pexCurrentlyWorking;
    }

    //--- DATABASE MAPPING : pex_remarks ( VARCHAR ) 
    public void setPexRemarks( String pexRemarks ) {
        this.pexRemarks = pexRemarks;
    }
    public String getPexRemarks() {
        return this.pexRemarks;
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

    //--- DATABASE MAPPING : profile_key ( BIGINT ) 
    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }
    
    
    


    public Long getPexCreatedBy() {
		return pexCreatedBy;
	}

	public void setPexCreatedBy(Long pexCreatedBy) {
		this.pexCreatedBy = pexCreatedBy;
	}

	//----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTIdDesignationMaster( TIdDesignationMasterEntitySearch tIdDesignationMaster ) {
        this.tIdDesignationMaster = tIdDesignationMaster;
    }
    public TIdDesignationMasterEntitySearch getTIdDesignationMaster() {
        return this.tIdDesignationMaster;
    }

    public void setTIdPersonalInformation( TIdPersonalInformationEntitySearch tIdPersonalInformation ) {
        this.tIdPersonalInformation = tIdPersonalInformation;
    }
    public TIdPersonalInformationEntitySearch getTIdPersonalInformation() {
        return this.tIdPersonalInformation;
    }
    
    public void setTIdCompanyMaster( TIdCompanyMasterEntitySearch tIdCompanyMaster ) {
        this.tIdCompanyMaster = tIdCompanyMaster;
    }
    public TIdCompanyMasterEntitySearch getTIdCompanyMaster() {
        return this.tIdCompanyMaster;
    }
    
    public void setTIdFunctionalAreaMaster( TIdFunctionalAreaMasterEntitySearch tIdFunctionalAreaMaster ) {
        this.tIdFunctionalAreaMaster = tIdFunctionalAreaMaster;
    }
    public TIdFunctionalAreaMasterEntitySearch getTIdFunctionalAreaMaster() {
        return this.tIdFunctionalAreaMaster;
    }
    
   /* public void setTIdBusinessTypeMaster( TIdBusinessTypeMasterEntitySearch tIdBusinessTypeMaster ) {
        this.tIdBusinessTypeMaster = tIdBusinessTypeMaster;
    }
    public TIdBusinessTypeMasterEntitySearch getTIdBusinessTypeMaster() {
        return this.tIdBusinessTypeMaster;
    }*/
    
    public TIdReferenceCodesDetailEntity gettIdReferenceCodesDetail() {
		return tIdReferenceCodesDetail;
	}
	public List<TIdCompanyIndustryLinkEntitySearch> getListOfTIdCompanyIndustryLinkEntitySearch() {
		return listOfTIdCompanyIndustryLinkEntitySearch;
	}

	public void setListOfTIdCompanyIndustryLinkEntitySearch(
			List<TIdCompanyIndustryLinkEntitySearch> listOfTIdCompanyIndustryLinkEntitySearch) {
		this.listOfTIdCompanyIndustryLinkEntitySearch = listOfTIdCompanyIndustryLinkEntitySearch;
	}
	
	public List<TIdPersonalInfoLinkEntitySearch> getListOfTIdPersonalInfoLink() {
		return listOfTIdPersonalInfoLink;
	}

	public void setListOfTIdPersonalInfoLink(List<TIdPersonalInfoLinkEntitySearch> listOfTIdPersonalInfoLink) {
		this.listOfTIdPersonalInfoLink = listOfTIdPersonalInfoLink;
	}

	public void settIdReferenceCodesDetail(TIdReferenceCodesDetailEntity tIdReferenceCodesDetail) {
		this.tIdReferenceCodesDetail = tIdReferenceCodesDetail;
	}

	
    public TIdCityMasterEntitySearch getTIdCityMasterSearch() {
		return tIdCityMasterSearch;
	}

	public void setTIdCityMasterSearch(TIdCityMasterEntitySearch tIdCityMasterSearch) {
		this.tIdCityMasterSearch = tIdCityMasterSearch;
	}

	
	public TIdStateMasterEntitySearch getTIdStateMasterSearch() {
		return tIdStateMasterSearch;
	}

	public void setTIdStateMasterSearch(TIdStateMasterEntitySearch tIdStateMasterSearch) {
		this.tIdStateMasterSearch = tIdStateMasterSearch;
	}

	
	public TIdCountryMasterEntitySearch getTIdCountryMasterSearch() {
		return tIdCountryMasterSearch;
	}

	public void setTIdCountryMasterSearch(TIdCountryMasterEntitySearch tIdCountryMasterSearch) {
		this.tIdCountryMasterSearch = tIdCountryMasterSearch;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pexKey);
        sb.append("]:"); 
        /*sb.append(pexCityKey);
        sb.append("|");*/
        //sb.append(pexStateKey);
       /* sb.append("|");
        sb.append(pexCountryKey);
        sb.append("|");*/
        sb.append(pexFromMonth);
        sb.append("|");
        sb.append(pexFromYear);
        sb.append("|");
        sb.append(pexToMonth);
        sb.append("|");
        sb.append(pexToYear);
        sb.append("|");
        sb.append(pexExperienceYears);
        sb.append("|");
        sb.append(pexCurrentlyWorking);
        sb.append("|");
        sb.append(pexRemarks);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(profileKey);
        
        sb.append("|");
        sb.append(pexCreatedBy);
        
        
        
        return sb.toString(); 
    } 

}
