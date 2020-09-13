package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "t_id_group_link_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_group_link_view" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdGroupLinkViewEntity.countAll", query="SELECT COUNT(x) FROM TIdGroupLinkViewEntity x" )
} )
public class TIdGroupLinkViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Id
    @Column(name="gl_key", nullable=false)
    private Long       glKey        ;

    @Column(name="gl_gh_key", nullable=false)
    private Long       glGhKey      ;

    @Column(name="gl_pin_key", nullable=false)
    private Long       glPinKey     ;

    @Column(name="gl_pin_name", length=201)
    private String     glPinName    ;

    @Column(name="active_status", nullable=false, length=10)
    private String     activeStatus ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Column(name="pex_key")
    private Long       pexKey   ;

    @Column(name="designation_key")
    private Long       designationKey   ;
    
    @Column(name="designation")
    private String     designation ;
    
    @Column(name="company_key")
    private Long       companyKey   ;
    
    @Column(name="company")
    private String     company ;
    
    @Column(name="role_key")
    private Long       roleKey   ;
    
    @Column(name="role")
    private String     role ;
    
    @Column(name="functional_area_key")
    private Long       functionalAreaKey   ;
    
    @Column(name="functional_area")
    private String     functionalArea ;
    

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdGroupLinkViewEntity() {
		super();
    }
    
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
