

/*
 * Created on 25 Apr 2019 ( Time 18:17:48 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a composite Primary Key  
// This Bean has a basic Primary Key (not composite) 

package com.id.wasta.bean;

import java.io.Serializable;
import java.math.BigDecimal;

//import org.hibernate.validator.constraints.* ;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TIdPersonalInfoAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private BigDecimal       piaKey       ;

    @NotNull 
     private BigDecimal       piaPinKey    ;

    @NotNull
    @Size( min = 1, max = 50 ) 
     private String     piaFieldType ;

    @NotNull
    @Size( min = 1, max = 20 ) 
     private String     piaShareType ;

    @NotNull
    @Size( min = 1, max = 20 ) 
     private String     piaAccessType ;

    @NotNull
    @Size( min = 1, max = 2250 ) 
     private String     piaAccessInfo ;

    @NotNull 
     private BigDecimal       createdBy    ;

    @NotNull
    @Size( min = 1, max = 1 ) 
     private String     activeStatus ;

    @NotNull 
     private BigDecimal       lockKey      ;



  
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPiaKey( BigDecimal piaKey ) {
        this.piaKey = piaKey ;
    }
    public BigDecimal getPiaKey() {
        return this.piaKey;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pia_pin_key ( BIGINT ) 
    public void setPiaPinKey( BigDecimal piaPinKey ) {
        this.piaPinKey = piaPinKey;
    }
    public BigDecimal getPiaPinKey() {
        return this.piaPinKey;
    }

    //--- DATABASE MAPPING : pia_field_type ( VARCHAR ) 
    public void setPiaFieldType( String piaFieldType ) {
        this.piaFieldType = piaFieldType;
    }
    public String getPiaFieldType() {
        return this.piaFieldType;
    }

    //--- DATABASE MAPPING : pia_share_type ( VARCHAR ) 
    public void setPiaShareType( String piaShareType ) {
        this.piaShareType = piaShareType;
    }
    public String getPiaShareType() {
        return this.piaShareType;
    }

    //--- DATABASE MAPPING : pia_access_type ( VARCHAR ) 
    public void setPiaAccessType( String piaAccessType ) {
        this.piaAccessType = piaAccessType;
    }
    public String getPiaAccessType() {
        return this.piaAccessType;
    }

    //--- DATABASE MAPPING : pia_access_info ( VARCHAR ) 
    public void setPiaAccessInfo( String piaAccessInfo ) {
        this.piaAccessInfo = piaAccessInfo;
    }
    public String getPiaAccessInfo() {
        return this.piaAccessInfo;
    }

    //--- DATABASE MAPPING : created_by ( BIGINT ) 
    public void setCreatedBy( BigDecimal createdBy ) {
        this.createdBy = createdBy;
    }
    public BigDecimal getCreatedBy() {
        return this.createdBy;
    }

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : lock_key ( BIGINT ) 
    public void setLockKey( BigDecimal lockKey ) {
        this.lockKey = lockKey;
    }
    public BigDecimal getLockKey() {
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
        sb.append(piaKey);
        sb.append("]:"); 
        sb.append(piaPinKey);
        sb.append("|");
        sb.append(piaFieldType);
        sb.append("|");
        sb.append(piaShareType);
        sb.append("|");
        sb.append(piaAccessType);
        sb.append("|");
        sb.append(piaAccessInfo);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 

}
