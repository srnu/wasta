/*
 * Created on 2 Feb 2017 ( Time 11:26:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TIdExperienceInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pexKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long pexPinKey;

    @NotNull
    private Long pexCompanyCmsKey;


    private Long pexCityKey;


    private Long pexStateKey;


    private Long pexCountryKey;


    private List<Long> listOfPexBusinessTypeKey;


    private Long pexDesignationKey;


    private Long pexFunctionalAreaKey;


    private Long pexRoleKey;

    @Size( max = 3 )
    private String pexFromMonth;


    private Long pexFromYear;

    @Size( max = 10 )
    private String pexToMonth;


    private Long pexToYear;


    private String pexExperienceYears;

    @NotNull
    @Size( min = 1, max = 1 )
    private String pexCurrentlyWorking;

    @Size( max = 2400 )
    private String pexRemarks;

    @NotNull
    private Long lockKey;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long profileKey;

    private Long otherCompanyCmsKey;
    
    private String otherCompanyCmsName;
    
    private Long otherDesignationKey;
    
    private String otherDesignationName;
    
    private Long otherRolekey;
    
    private String otherRoleName;
    
    private Long otherFunctionalAreaKey;
    
    private String otherFunctionalAreaName;
    
    private String otherCityName;
    
    private String otherStateName;
    
    private String otherIndustryName;

    private String auditJson;
    
    
    private Long pexCreatedBy;
    
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
    public void setPexPinKey( Long pexPinKey ) {
        this.pexPinKey = pexPinKey;
    }
    public Long getPexPinKey() {
        return this.pexPinKey;
    }

    public void setPexCompanyCmsKey( Long pexCompanyCmsKey ) {
        this.pexCompanyCmsKey = pexCompanyCmsKey;
    }
    public Long getPexCompanyCmsKey() {
        return this.pexCompanyCmsKey;
    }

    public void setPexCityKey( Long pexCityKey ) {
        this.pexCityKey = pexCityKey;
    }
    public Long getPexCityKey() {
        return this.pexCityKey;
    }

    public void setPexStateKey( Long pexStateKey ) {
        this.pexStateKey = pexStateKey;
    }
    public Long getPexStateKey() {
        return this.pexStateKey;
    }

    public void setPexCountryKey( Long pexCountryKey ) {
        this.pexCountryKey = pexCountryKey;
    }
    public Long getPexCountryKey() {
        return this.pexCountryKey;
    }

    public List<Long> getListOfPexBusinessTypeKey() {
		return listOfPexBusinessTypeKey;
	}

	public void setListOfPexBusinessTypeKey(List<Long> listOfPexBusinessTypeKey) {
		this.listOfPexBusinessTypeKey = listOfPexBusinessTypeKey;
	}

	public void setPexDesignationKey( Long pexDesignationKey ) {
        this.pexDesignationKey = pexDesignationKey;
    }
    public Long getPexDesignationKey() {
        return this.pexDesignationKey;
    }

    public void setPexFunctionalAreaKey( Long pexFunctionalAreaKey ) {
        this.pexFunctionalAreaKey = pexFunctionalAreaKey;
    }
    public Long getPexFunctionalAreaKey() {
        return this.pexFunctionalAreaKey;
    }

    public void setPexRoleKey( Long pexRoleKey ) {
        this.pexRoleKey = pexRoleKey;
    }
    public Long getPexRoleKey() {
        return this.pexRoleKey;
    }

    public void setPexFromMonth( String pexFromMonth ) {
        this.pexFromMonth = pexFromMonth;
    }
    public String getPexFromMonth() {
        return this.pexFromMonth;
    }

    public void setPexFromYear( Long pexFromYear ) {
        this.pexFromYear = pexFromYear;
    }
    public Long getPexFromYear() {
        return this.pexFromYear;
    }

    public void setPexToMonth( String pexToMonth ) {
        this.pexToMonth = pexToMonth;
    }
    public String getPexToMonth() {
        return this.pexToMonth;
    }

    public void setPexToYear( Long pexToYear ) {
        this.pexToYear = pexToYear;
    }
    public Long getPexToYear() {
        return this.pexToYear;
    }

    public void setPexExperienceYears( String pexExperienceYears ) {
        this.pexExperienceYears = pexExperienceYears;
    }
    public String getPexExperienceYears() {
        return this.pexExperienceYears;
    }

    public void setPexCurrentlyWorking( String pexCurrentlyWorking ) {
        this.pexCurrentlyWorking = pexCurrentlyWorking;
    }
    public String getPexCurrentlyWorking() {
        return this.pexCurrentlyWorking;
    }

    public void setPexRemarks( String pexRemarks ) {
        this.pexRemarks = pexRemarks;
    }
    public String getPexRemarks() {
        return this.pexRemarks;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public String getOtherCityName() {
		return otherCityName;
	}
	public void setOtherCityName(String otherCityName) {
		this.otherCityName = otherCityName;
	}
	
	public String getOtherStateName() {
		return otherStateName;
	}
	public void setOtherStateName(String otherStateName) {
		this.otherStateName = otherStateName;
	}

	public String getOtherIndustryName() {
		return otherIndustryName;
	}
	public void setOtherIndustryName(String otherIndustryName) {
		this.otherIndustryName = otherIndustryName;
	}
	
	public Long getOtherCompanyCmsKey() {
		return otherCompanyCmsKey;
	}
	public void setOtherCompanyCmsKey(Long otherCompanyCmsKey) {
		this.otherCompanyCmsKey = otherCompanyCmsKey;
	}

	public String getOtherCompanyCmsName() {
		return otherCompanyCmsName;
	}
	public void setOtherCompanyCmsName(String otherCompanyCmsName) {
		this.otherCompanyCmsName = otherCompanyCmsName;
	}

	public Long getOtherDesignationKey() {
		return otherDesignationKey;
	}
	public void setOtherDesignationKey(Long otherDesignationKey) {
		this.otherDesignationKey = otherDesignationKey;
	}

	public String getOtherDesignationName() {
		return otherDesignationName;
	}
	public void setOtherDesignationName(String otherDesignationName) {
		this.otherDesignationName = otherDesignationName;
	}

	public Long getOtherFunctionalAreaKey() {
		return otherFunctionalAreaKey;
	}
	public void setOtherFunctionalAreaKey(Long otherFunctionalAreaKey) {
		this.otherFunctionalAreaKey = otherFunctionalAreaKey;
	}

	public String getOtherFunctionalAreaName() {
		return otherFunctionalAreaName;
	}
	public void setOtherFunctionalAreaName(String otherFunctionalAreaName) {
		this.otherFunctionalAreaName = otherFunctionalAreaName;
	}

	public Long getOtherRolekey() {
		return otherRolekey;
	}
	public void setOtherRolekey(Long otherRolekey) {
		this.otherRolekey = otherRolekey;
	}

	public String getOtherRoleName() {
		return otherRoleName;
	}
	public void setOtherRoleName(String otherRoleName) {
		this.otherRoleName = otherRoleName;
	} 
	
	public String getAuditJson() {
		return auditJson;
	}

	public void setAuditJson(String auditJson) {
		this.auditJson = auditJson;
	}
	
	public Long getPexCreatedBy() {
		return pexCreatedBy;
	}

	public void setPexCreatedBy(Long pexCreatedBy) {
		this.pexCreatedBy = pexCreatedBy;
	}
	
	
	
	
	
	
	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	
	

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(pexKey);
        sb.append("|");
        sb.append(pexPinKey);
        sb.append("|");
        sb.append(pexCompanyCmsKey);
        sb.append("|");
        sb.append(pexCityKey);
        sb.append("|");
        sb.append(pexStateKey);
        sb.append("|");
        sb.append(pexCountryKey);
        sb.append("|");
        sb.append(pexDesignationKey);
        sb.append("|");
        sb.append(pexFunctionalAreaKey);
        sb.append("|");
        sb.append(pexRoleKey);
        sb.append("|");
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