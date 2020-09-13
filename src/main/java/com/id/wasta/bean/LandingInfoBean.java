package com.id.wasta.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.util.action.CommonConstants;

public class LandingInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long       ldKey        ;

    private String     ldUserName   ;

    private Long       ldUserPinKey ;

    private String     ldContactName ;

    private Long       ldContactPinKey ;

    private String     ldCompany    ;

    private String     ldIndustry   ;

    private String     ldCountry    ;
    
    private String     ldTypeChange    ;
    
    private String     ldAuditBoxName    ;
    
    private String     ldAuditFieldName    ;
    
    private String     ldAuditOldUpdate    ;
    
    private String     ldAuditLatestUpdate    ;

    private String     ldBoxName    ; //menuType

    private String     ldFieldName  ;
    
    private String     ldOldUpdate ;

    private String     ldLatestUpdate ;

    private Long       ldUpdateKey  ;

    private Boolean    ldReadFlag   ;

    private Long       lockKey      ;

    private Long       profileKey   ;
    
    private String topMenuType;
    
    private Long loggedPinKey;
    
    private int page;
    
    private int size; 
    
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date    createdOn;
    
    private String  auditCreatedOn;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LandingInfoBean() {
		super();
    }
   
    public LandingInfoBean(Long ldKey, String ldUserName, Long ldUserPinKey, String ldContactName, Long ldContactPinKey,
    		String ldCompany, String ldIndustry, String ldCountry, String ldBoxName, String ldFieldName,
    		String ldLatestUpdate, Long ldUpdateKey, Boolean ldReadFlag, Long lockKey, Long profileKey, Date createdOn, int read) {
		super();
		this.ldKey = ldKey;
		this.ldUserName = ldUserName;
		this.ldUserPinKey = ldUserPinKey;
		this.ldContactName = ldContactName;
		this.ldContactPinKey = ldContactPinKey; 
		this.ldCompany = ldCompany;
		this.ldIndustry = ldIndustry;
		this.ldCountry = ldCountry;
		this.ldBoxName = ldBoxName;
		this.ldFieldName = ldFieldName;
		this.ldLatestUpdate = ldLatestUpdate;
		this.ldUpdateKey = ldUpdateKey;
		this.ldReadFlag = ldReadFlag;
		this.lockKey = lockKey;
		this.profileKey = profileKey;
		this.createdOn = createdOn;
		if(read==1) {
			this.ldReadFlag = true;
		} else { 
			this.ldReadFlag = false;
		}
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
    public void setLdUserName( String ldUserName ) {
        this.ldUserName = ldUserName;
    }
    public String getLdUserName() {
        return this.ldUserName;
    }

    public void setLdUserPinKey( Long ldUserPinKey ) {
        this.ldUserPinKey = ldUserPinKey;
    }
    public Long getLdUserPinKey() {
        return this.ldUserPinKey;
    }

    public void setLdContactName( String ldContactName ) {
        this.ldContactName = ldContactName;
    }
    public String getLdContactName() {
        return this.ldContactName;
    }

    public void setLdContactPinKey( Long ldContactPinKey ) {
        this.ldContactPinKey = ldContactPinKey;
    }
    public Long getLdContactPinKey() {
        return this.ldContactPinKey;
    }

    public void setLdCompany( String ldCompany ) {
        this.ldCompany = ldCompany;
    }
    public String getLdCompany() {
        return this.ldCompany;
    }

    public void setLdIndustry( String ldIndustry ) {
        this.ldIndustry = ldIndustry;
    }
    public String getLdIndustry() {
        return this.ldIndustry;
    }

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

	public void setLdBoxName( String ldBoxName ) {
        this.ldBoxName = ldBoxName;
    }
    public String getLdBoxName() {
        return this.ldBoxName;
    }

    public void setLdFieldName( String ldFieldName ) {
        this.ldFieldName = ldFieldName;
    }
    public String getLdFieldName() {
        return this.ldFieldName;
    }
    
    public String getLdOldUpdate() {
		return ldOldUpdate;
	}
	public void setLdOldUpdate(String ldOldUpdate) {
		this.ldOldUpdate = ldOldUpdate;
	}

    public void setLdLatestUpdate( String ldLatestUpdate ) {
        this.ldLatestUpdate = ldLatestUpdate;
    }
    public String getLdLatestUpdate() {
        return this.ldLatestUpdate;
    }

    public void setLdUpdateKey( Long ldUpdateKey ) {
        this.ldUpdateKey = ldUpdateKey;
    }
    public Long getLdUpdateKey() {
        return this.ldUpdateKey;
    }

    public void setLdReadFlag( Boolean ldReadFlag ) {
        this.ldReadFlag = ldReadFlag;
    }
    public Boolean getLdReadFlag() {
        return this.ldReadFlag;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }
    
	public String getTopMenuType() {
		return topMenuType;
	}

	public void setTopMenuType(String topMenuType) {
		this.topMenuType = topMenuType;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getAuditCreatedOn() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date date = createdOn;
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date);
	}
	
	public void setAuditCreatedOn(String auditCreatedOn) {
		this.auditCreatedOn = auditCreatedOn;
	}
	
	public Long getLoggedPinKey() {
		return loggedPinKey;
	}

	public void setLoggedPinKey(Long loggedPinKey) {
		this.loggedPinKey = loggedPinKey;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
        sb.append(topMenuType);
        return sb.toString(); 
    } 

}
