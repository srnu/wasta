/*
 * Created on 1 Nov 2016 ( Time 10:41:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.id.wasta.util.action.CommonConstants;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdProductAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long pattKey;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long pattProductKey;

    @NotNull
    @Size( min = 1, max = 1 )
    private String pattReferenceType;

    @NotNull
    private Long pattReferenceKey;

    @NotNull
    private Long pattSerial;

    @Size( max = 1 )
    private String pattDirection;

    @NotNull
    private Long pattInfobaseKey;

    @NotNull
    private Long pattFilePathKey;

    @NotNull
    @Size( min = 1, max = 240 )
    private String pattFileName;

    @NotNull
    @Size( min = 1, max = 10 )
    private String pattFileType;

    @NotNull
    private Long pattUploadedBy;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date pattUploadedOn;

    @NotNull
    @Size( min = 1, max = 75 )
    private String pattUploadedIp;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @Size( max = 240 )
    private String pattInternalFileName;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date pattActiveFrom;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
    private Date pattActiveTo;

    @NotNull
    private Long profileKey;

    @NotNull
    private Long lockKey;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPattKey( Long pattKey ) {
        this.pattKey = pattKey ;
    }

    public Long getPattKey() {
        return this.pattKey;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPattProductKey( Long pattProductKey ) {
        this.pattProductKey = pattProductKey;
    }
    public Long getPattProductKey() {
        return this.pattProductKey;
    }

    public void setPattReferenceType( String pattReferenceType ) {
        this.pattReferenceType = pattReferenceType;
    }
    public String getPattReferenceType() {
        return this.pattReferenceType;
    }

    public void setPattReferenceKey( Long pattReferenceKey ) {
        this.pattReferenceKey = pattReferenceKey;
    }
    public Long getPattReferenceKey() {
        return this.pattReferenceKey;
    }

    public void setPattSerial( Long pattSerial ) {
        this.pattSerial = pattSerial;
    }
    public Long getPattSerial() {
        return this.pattSerial;
    }

    public void setPattDirection( String pattDirection ) {
        this.pattDirection = pattDirection;
    }
    public String getPattDirection() {
        return this.pattDirection;
    }

    public void setPattInfobaseKey( Long pattInfobaseKey ) {
        this.pattInfobaseKey = pattInfobaseKey;
    }
    public Long getPattInfobaseKey() {
        return this.pattInfobaseKey;
    }

    public void setPattFilePathKey( Long pattFilePathKey ) {
        this.pattFilePathKey = pattFilePathKey;
    }
    public Long getPattFilePathKey() {
        return this.pattFilePathKey;
    }

    public void setPattFileName( String pattFileName ) {
        this.pattFileName = pattFileName;
    }
    public String getPattFileName() {
        return this.pattFileName;
    }

    public void setPattFileType( String pattFileType ) {
        this.pattFileType = pattFileType;
    }
    public String getPattFileType() {
        return this.pattFileType;
    }

    public void setPattUploadedBy( Long pattUploadedBy ) {
        this.pattUploadedBy = pattUploadedBy;
    }
    public Long getPattUploadedBy() {
        return this.pattUploadedBy;
    }

    public void setPattUploadedOn( Date pattUploadedOn ) {
        this.pattUploadedOn = pattUploadedOn;
    }
    public Date getPattUploadedOn() {
        return this.pattUploadedOn;
    }

    public void setPattUploadedIp( String pattUploadedIp ) {
        this.pattUploadedIp = pattUploadedIp;
    }
    public String getPattUploadedIp() {
        return this.pattUploadedIp;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    public void setPattInternalFileName( String pattInternalFileName ) {
        this.pattInternalFileName = pattInternalFileName;
    }
    public String getPattInternalFileName() {
        return this.pattInternalFileName;
    }

    public void setPattActiveFrom( Date pattActiveFrom ) {
        this.pattActiveFrom = pattActiveFrom;
    }
    public Date getPattActiveFrom() {
        return this.pattActiveFrom;
    }

    public void setPattActiveTo( Date pattActiveTo ) {
        this.pattActiveTo = pattActiveTo;
    }
    public Date getPattActiveTo() {
        return this.pattActiveTo;
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


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(pattKey);
        sb.append("|");
        sb.append(pattProductKey);
        sb.append("|");
        sb.append(pattReferenceType);
        sb.append("|");
        sb.append(pattReferenceKey);
        sb.append("|");
        sb.append(pattSerial);
        sb.append("|");
        sb.append(pattDirection);
        sb.append("|");
        sb.append(pattInfobaseKey);
        sb.append("|");
        sb.append(pattFilePathKey);
        sb.append("|");
        sb.append(pattFileName);
        sb.append("|");
        sb.append(pattFileType);
        sb.append("|");
        sb.append(pattUploadedBy);
        sb.append("|");
        sb.append(pattUploadedOn);
        sb.append("|");
        sb.append(pattUploadedIp);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(pattInternalFileName);
        sb.append("|");
        sb.append(pattActiveFrom);
        sb.append("|");
        sb.append(pattActiveTo);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(lockKey);
        return sb.toString(); 
    } 


}
