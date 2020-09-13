

/*
 * Created on 19 Apr 2019 ( Time 12:50:42 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a composite Primary Key  
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean;

import java.io.Serializable;

//import org.hibernate.validator.constraints.* ;
import javax.validation.constraints.NotNull;

public class TIdLandingExperienceLink implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long       llKey        ;

    @NotNull 
     private Long       llLdKey      ;

    @NotNull 
     private Long       llPinKey     ;

    @NotNull 
     private Long       lockKey      ;

    @NotNull 
     private Long       profileKey   ;



  
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLlKey( Long llKey ) {
        this.llKey = llKey ;
    }
    public Long getLlKey() {
        return this.llKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ll_ld_key ( BIGINT ) 
    public void setLlLdKey( Long llLdKey ) {
        this.llLdKey = llLdKey;
    }
    public Long getLlLdKey() {
        return this.llLdKey;
    }

    //--- DATABASE MAPPING : ll_pin_key ( BIGINT ) 
    public void setLlPinKey( Long llPinKey ) {
        this.llPinKey = llPinKey;
    }
    public Long getLlPinKey() {
        return this.llPinKey;
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

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(llKey);
        sb.append("]:"); 
        sb.append(llLdKey);
        sb.append("|");
        sb.append(llPinKey);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        return sb.toString(); 
    } 

}

