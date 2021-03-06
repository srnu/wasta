

/*
 * Created on 26 Sep 2017 ( Time 17:47:28 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
//import org.hibernate.validator.constraints.* ;
import javax.validation.constraints.Size;

public class TIdUserMasterViewSearch implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull 
     private Long       key          ;

    @NotNull
    @Size( min = 1, max = 50 ) 
     private String     code         ;

    @Size( max = 151 ) 
     private String     name         ;

    @Size( max = 41 ) 
     private String     userrolekey  ;

    @NotNull
    @Size( min = 1, max = 1 ) 
     private String     activeStatus ;

 
     private Date       activeFrom   ;

 
     private Date       activeTo     ;

    @NotNull 
     private Long       profileKey   ;

    @NotNull 
     private Long       lockKey      ;

    @NotNull 
     private Long       userPinKey   ;

 
     private String       roleKey      ;

    @Size( max = 200 ) 
     private String     roleName     ;

 
     private Long       countryKey   ;

    @Size( max = 240 ) 
     private String     countryName  ;

 
     private Long       designationKey ;

    @Size( max = 240 ) 
     private String     designation  ;

 
     private Long       companyKey   ;

    @Size( max = 240 ) 
     private String     company      ;



  
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : key ( BIGINT ) 
    public void setKey( Long key ) {
        this.key = key;
    }
    public Long getKey() {
        return this.key;
    }

    //--- DATABASE MAPPING : code ( VARCHAR ) 
    public void setCode( String code ) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }

    //--- DATABASE MAPPING : NAME ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : userRoleKey ( VARCHAR ) 
    public void setUserrolekey( String userrolekey ) {
        this.userrolekey = userrolekey;
    }
    public String getUserrolekey() {
        return this.userrolekey;
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

    //--- DATABASE MAPPING : user_pin_key ( BIGINT ) 
    public void setUserPinKey( Long userPinKey ) {
        this.userPinKey = userPinKey;
    }
    public Long getUserPinKey() {
        return this.userPinKey;
    }

    //--- DATABASE MAPPING : role_key ( BIGINT ) 
    public void setRoleKey( String roleKey ) {
        this.roleKey = roleKey;
    }
    public String getRoleKey() {
        return this.roleKey;
    }

    //--- DATABASE MAPPING : role_name ( VARCHAR ) 
    public void setRoleName( String roleName ) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return this.roleName;
    }

    //--- DATABASE MAPPING : country_key ( BIGINT ) 
    public void setCountryKey( Long countryKey ) {
        this.countryKey = countryKey;
    }
    public Long getCountryKey() {
        return this.countryKey;
    }

    //--- DATABASE MAPPING : country_name ( VARCHAR ) 
    public void setCountryName( String countryName ) {
        this.countryName = countryName;
    }
    public String getCountryName() {
        return this.countryName;
    }

    //--- DATABASE MAPPING : designation_key ( BIGINT ) 
    public void setDesignationKey( Long designationKey ) {
        this.designationKey = designationKey;
    }
    public Long getDesignationKey() {
        return this.designationKey;
    }

    //--- DATABASE MAPPING : designation ( VARCHAR ) 
    public void setDesignation( String designation ) {
        this.designation = designation;
    }
    public String getDesignation() {
        return this.designation;
    }

    //--- DATABASE MAPPING : company_key ( BIGINT ) 
    public void setCompanyKey( Long companyKey ) {
        this.companyKey = companyKey;
    }
    public Long getCompanyKey() {
        return this.companyKey;
    }

    //--- DATABASE MAPPING : company ( VARCHAR ) 
    public void setCompany( String company ) {
        this.company = company;
    }
    public String getCompany() {
        return this.company;
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
        sb.append("]:"); 
        sb.append(key);
        sb.append("|");
        sb.append(code);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(userrolekey);
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
        sb.append("|");
        sb.append(userPinKey);
        sb.append("|");
        sb.append(roleKey);
        sb.append("|");
        sb.append(roleName);
        sb.append("|");
        sb.append(countryKey);
        sb.append("|");
        sb.append(countryName);
        sb.append("|");
        sb.append(designationKey);
        sb.append("|");
        sb.append(designation);
        sb.append("|");
        sb.append(companyKey);
        sb.append("|");
        sb.append(company);
        return sb.toString(); 
    } 

}

