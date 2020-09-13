/*
 * Created on 24 Dec 2018 ( Time 11:50:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TIdUserMasterListView implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long userKey;

    @NotNull
    @Size( min = 1, max = 50 )
    private String userCode;

    @Size( max = 75 )
    private String userFirstName;

    @Size( max = 75 )
    private String userMiddleName;

    @NotNull
    @Size( min = 1, max = 75 )
    private String userLastName;

    @Size( max = 240 )
    private String userDisplayName;


    private Long userCompanyKey;


    private Long userAddressLink;

    @NotNull
    private Long userDefaultProfileKey;


    private Long userVerificationCode;

    @NotNull
    private Long activeStatus;


    private Date userActiveFrom;


    private Date userActiveTo;

    @NotNull
    @Size( min = 1, max = 75 )
    private String userPassword;

    @NotNull
    private Long userPinKey;

    @NotNull
    private Long userLockCount;

    @NotNull
    private Long profileKey;

    @NotNull
    private Long lockKey;


    private Long uprlUserRoleKey;

    @Size( max = 240 )
    private String name;

    @Size( max = 75 )
    private String code;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setUserKey( Long userKey ) {
        this.userKey = userKey;
    }
    public Long getUserKey() {
        return this.userKey;
    }

    public void setUserCode( String userCode ) {
        this.userCode = userCode;
    }
    public String getUserCode() {
        return this.userCode;
    }

    public void setUserFirstName( String userFirstName ) {
        this.userFirstName = userFirstName;
    }
    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserMiddleName( String userMiddleName ) {
        this.userMiddleName = userMiddleName;
    }
    public String getUserMiddleName() {
        return this.userMiddleName;
    }

    public void setUserLastName( String userLastName ) {
        this.userLastName = userLastName;
    }
    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserDisplayName( String userDisplayName ) {
        this.userDisplayName = userDisplayName;
    }
    public String getUserDisplayName() {
        return this.userDisplayName;
    }

    public void setUserCompanyKey( Long userCompanyKey ) {
        this.userCompanyKey = userCompanyKey;
    }
    public Long getUserCompanyKey() {
        return this.userCompanyKey;
    }

    public void setUserAddressLink( Long userAddressLink ) {
        this.userAddressLink = userAddressLink;
    }
    public Long getUserAddressLink() {
        return this.userAddressLink;
    }

    public void setUserDefaultProfileKey( Long userDefaultProfileKey ) {
        this.userDefaultProfileKey = userDefaultProfileKey;
    }
    public Long getUserDefaultProfileKey() {
        return this.userDefaultProfileKey;
    }

    public void setUserVerificationCode( Long userVerificationCode ) {
        this.userVerificationCode = userVerificationCode;
    }
    public Long getUserVerificationCode() {
        return this.userVerificationCode;
    }

    public void setActiveStatus( Long activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public Long getActiveStatus() {
        return this.activeStatus;
    }

    public void setUserActiveFrom( Date userActiveFrom ) {
        this.userActiveFrom = userActiveFrom;
    }
    public Date getUserActiveFrom() {
        return this.userActiveFrom;
    }

    public void setUserActiveTo( Date userActiveTo ) {
        this.userActiveTo = userActiveTo;
    }
    public Date getUserActiveTo() {
        return this.userActiveTo;
    }

    public void setUserPassword( String userPassword ) {
        this.userPassword = userPassword;
    }
    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPinKey( Long userPinKey ) {
        this.userPinKey = userPinKey;
    }
    public Long getUserPinKey() {
        return this.userPinKey;
    }

    public void setUserLockCount( Long userLockCount ) {
        this.userLockCount = userLockCount;
    }
    public Long getUserLockCount() {
        return this.userLockCount;
    }

    public void setProfileKey( Long profileKey ) {
        this.profileKey = profileKey;
    }
    public Long getProfileKey() {
        return this.profileKey;
    }

    public void setLockKey( Long lockKey ) {
        this.lockKey = lockKey;
    }
    public Long getLockKey() {
        return this.lockKey;
    }

    public void setUprlUserRoleKey( Long uprlUserRoleKey ) {
        this.uprlUserRoleKey = uprlUserRoleKey;
    }
    public Long getUprlUserRoleKey() {
        return this.uprlUserRoleKey;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setCode( String code ) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(userKey);
        sb.append("|");
        sb.append(userCode);
        sb.append("|");
        sb.append(userFirstName);
        sb.append("|");
        sb.append(userMiddleName);
        sb.append("|");
        sb.append(userLastName);
        sb.append("|");
        sb.append(userDisplayName);
        sb.append("|");
        sb.append(userCompanyKey);
        sb.append("|");
        sb.append(userAddressLink);
        sb.append("|");
        sb.append(userDefaultProfileKey);
        sb.append("|");
        sb.append(userVerificationCode);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(userActiveFrom);
        sb.append("|");
        sb.append(userActiveTo);
        sb.append("|");
        sb.append(userPassword);
        sb.append("|");
        sb.append(userPinKey);
        sb.append("|");
        sb.append(userLockCount);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(uprlUserRoleKey);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(code);
        return sb.toString(); 
    } 


}
