package com.id.wasta.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TIdGroupLinkView implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull 
     private Long       glKey        ;

    @NotNull 
     private Long       glGhKey      ;

    @NotNull 
     private Long       glPinKey     ;

    @Size( max = 201 ) 
     private String     glPinName    ;

    @NotNull
    @Size( min = 1, max = 10 ) 
     private String     activeStatus ;

    @NotNull 
     private Long       lockKey      ;

    @NotNull 
     private Long       profileKey   ;

    private Long       pexKey   ;

    private Long       designationKey   ;
    
    private String     designation ;
    
    private Long       companyKey   ;
    
    private String     company ;
    
    private Long       roleKey   ;
    
    private String     role ;
    
    private Long       functionalAreaKey   ;
    
    private String     functionalArea ;

  
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : gl_key ( BIGINT ) 
    public void setGlKey( Long glKey ) {
        this.glKey = glKey;
    }
    public Long getGlKey() {
        return this.glKey;
    }

    //--- DATABASE MAPPING : gl_gh_key ( BIGINT ) 
    public void setGlGhKey( Long glGhKey ) {
        this.glGhKey = glGhKey;
    }
    public Long getGlGhKey() {
        return this.glGhKey;
    }

    //--- DATABASE MAPPING : gl_pin_key ( BIGINT ) 
    public void setGlPinKey( Long glPinKey ) {
        this.glPinKey = glPinKey;
    }
    public Long getGlPinKey() {
        return this.glPinKey;
    }

    //--- DATABASE MAPPING : gl_pin_name ( VARCHAR ) 
    public void setGlPinName( String glPinName ) {
        this.glPinName = glPinName;
    }
    public String getGlPinName() {
        return this.glPinName;
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

    public Long getPexKey() {
		return pexKey;
	}
	public void setPexKey(Long pexKey) {
		this.pexKey = pexKey;
	}
	public Long getDesignationKey() {
		return designationKey;
	}
	public void setDesignationKey(Long designationKey) {
		this.designationKey = designationKey;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getCompanyKey() {
		return companyKey;
	}
	public void setCompanyKey(Long companyKey) {
		this.companyKey = companyKey;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Long getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(Long roleKey) {
		this.roleKey = roleKey;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getFunctionalAreaKey() {
		return functionalAreaKey;
	}
	public void setFunctionalAreaKey(Long functionalAreaKey) {
		this.functionalAreaKey = functionalAreaKey;
	}
	public String getFunctionalArea() {
		return functionalArea;
	}
	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}
		
	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append("]:"); 
        sb.append(glKey);
        sb.append("|");
        sb.append(glGhKey);
        sb.append("|");
        sb.append(glPinKey);
        sb.append("|");
        sb.append(glPinName);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}

