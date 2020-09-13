/*
 * Created on 7 Feb 2017 ( Time 18:03:32 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class TIdAwardsInformationView implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Long piaKey;

    @NotNull
    private Long piaPinKey;

    @NotNull
    @Size( min = 1, max = 240 )
    private String piaAwardName;

    @Size( max = 240 )
    private Long piaPosition;

    @Size( max = 240 )
    private String piaPositionOthers;

    @Size( max = 240 )
    private Long piaProvidedBy;
    
    private String     piaProvidedByType ;

    @Size( max = 240 )
    private String piaProvidedByOthers;

    @Size( max = 3 )
    private String piaMonth;


    private String piaYear;

    @Size( max = 1000 )
    private String piaDescription;

    @NotNull
    @Size( min = 1, max = 75 )
    private String activeStatus;

    @NotNull
    private Long lockKey;

    @NotNull
    private Long profileKey;


    private Long videoCount;


    private Long imageCount;


    private Long docCount;
    
    private String desigCode;
    
    private String desigName;
    
    private String providedByName;

    private boolean viewAccessFlag = true;
    
    @Column(name="pia_position_status")
    private String piaPositionStatus;
    
    @Column(name="pia_provided_by_status")
    private String piaProvidedByStatus;
    
    
    @Column(name="pia_created_by",length=20)
    private Long piaCreatedBy;
    
    
    
     //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPiaKey( Long piaKey ) {
        this.piaKey = piaKey;
    }
    public Long getPiaKey() {
        return this.piaKey;
    }

    public void setPiaPinKey( Long piaPinKey ) {
        this.piaPinKey = piaPinKey;
    }
    public Long getPiaPinKey() {
        return this.piaPinKey;
    }

    public void setPiaAwardName( String piaAwardName ) {
        this.piaAwardName = piaAwardName;
    }
    public String getPiaAwardName() {
        return this.piaAwardName;
    }

    public void setPiaPosition( Long piaPosition ) {
        this.piaPosition = piaPosition;
    }
    public Long getPiaPosition() {
        return this.piaPosition;
    }

    public void setPiaPositionOthers( String piaPositionOthers ) {
        this.piaPositionOthers = piaPositionOthers;
    }
    public String getPiaPositionOthers() {
        return this.piaPositionOthers;
    }

    public void setPiaProvidedBy( Long piaProvidedBy ) {
        this.piaProvidedBy = piaProvidedBy;
    }
    public Long getPiaProvidedBy() {
        return this.piaProvidedBy;
    }

    public void setPiaProvidedByOthers( String piaProvidedByOthers ) {
        this.piaProvidedByOthers = piaProvidedByOthers;
    }
    public String getPiaProvidedByOthers() {
        return this.piaProvidedByOthers;
    }

    public void setPiaMonth( String piaMonth ) {
        this.piaMonth = piaMonth;
    }
    public String getPiaMonth() {
        return this.piaMonth;
    }

    public void setPiaYear( String piaYear ) {
        this.piaYear = piaYear;
    }
    public String getPiaYear() {
        return this.piaYear;
    }

    public void setPiaDescription( String piaDescription ) {
        this.piaDescription = piaDescription;
    }
    public String getPiaDescription() {
        return this.piaDescription;
    }

    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
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

    public void setVideoCount( Long videoCount ) {
        this.videoCount = videoCount;
    }
    public Long getVideoCount() {
        return this.videoCount;
    }

    public void setImageCount( Long imageCount ) {
        this.imageCount = imageCount;
    }
    public Long getImageCount() {
        return this.imageCount;
    }

    public void setDocCount( Long docCount ) {
        this.docCount = docCount;
    }
    public Long getDocCount() {
        return this.docCount;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String getDesigCode() {
		return desigCode;
	}
	public void setDesigCode(String desigCode) {
		this.desigCode = desigCode;
	}
	public String getDesigName() {
		return desigName;
	}
	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}
	
	public String getPiaProvidedByType() {
		return piaProvidedByType;
	}
	public void setPiaProvidedByType(String piaProvidedByType) {
		this.piaProvidedByType = piaProvidedByType;
	}
	public String getProvidedByName() {
		return providedByName;
	}
	public void setProvidedByName(String providedByName) {
		this.providedByName = providedByName;
	}
	
	public boolean isViewAccessFlag() {
		return viewAccessFlag;
	}
	public void setViewAccessFlag(boolean viewAccessFlag) {
		this.viewAccessFlag = viewAccessFlag;
	}
	
	public String getPiaPositionStatus() {
		return piaPositionStatus;
	}

	public void setPiaPositionStatus(String piaPositionStatus) {
		this.piaPositionStatus = piaPositionStatus;
	}

	public String getPiaProvidedByStatus() {
		return piaProvidedByStatus;
	}

	public void setPiaProvidedByStatus(String piaProvidedByStatus) {
		this.piaProvidedByStatus = piaProvidedByStatus;
	}
	
	
	public Long getPiaCreatedBy() {
		return piaCreatedBy;
	}
	public void setPiaCreatedBy(Long piaCreatedBy) {
		this.piaCreatedBy = piaCreatedBy;
	}
	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(piaKey);
        sb.append("|");
        sb.append(piaPinKey);
        sb.append("|");
        sb.append(piaAwardName);
        sb.append("|");
        sb.append(piaPosition);
        sb.append("|");
        sb.append(piaPositionOthers);
        sb.append("|");
        sb.append(piaProvidedBy);
        sb.append("|");
        sb.append(piaProvidedByOthers);
        sb.append("|");
        sb.append(piaMonth);
        sb.append("|");
        sb.append(piaYear);
        sb.append("|");
        sb.append(piaDescription);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(videoCount);
        sb.append("|");
        sb.append(imageCount);
        sb.append("|");
        sb.append(docCount);
        sb.append("|");
        sb.append(piaPositionStatus);
        sb.append("|");
        sb.append(piaProvidedByStatus);
        sb.append("|");
        sb.append(piaCreatedBy);
        return sb.toString(); 
    } 


}