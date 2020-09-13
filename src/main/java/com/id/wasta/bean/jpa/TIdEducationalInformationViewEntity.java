package com.id.wasta.bean.jpa;

import java.io.Serializable;
import java.util.List;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Persistent class for entity stored in table "t_id_educational_information_view"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="t_id_educational_information_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdEducationalInformationViewEntity.countAll", query="SELECT COUNT(x) FROM TIdEducationalInformationViewEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIdEducationalInformationViewEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Id
    @Column(name="pei_key", nullable=false)
    private Long       peiKey       ;

    @Column(name="pei_pin_key", nullable=false)
    private Long       peiPinKey    ;

    @Column(name="pei_qualification_key", nullable=false)
    private Long       peiQualificationKey ;

    @Column(name="pei_edu_institute_key", nullable=false)
    private Long       peiEduInstituteKey ;

    @Column(name="pei_from_month", length=3)
    private String     peiFromMonth ;

    @Column(name="pei_from_year")
    private String       peiFromYear  ;

    @Column(name="pei_to_month", length=3)
    private String     peiToMonth   ;

    @Column(name="pei_to_year")
    private String       peiToYear    ;

    @Column(name="pei_remarks", length=1000)
    private String     peiRemarks   ;

    @Column(name="lock_key", nullable=false)
    private Long       lockKey      ;

    @Column(name="profile_key", nullable=false)
    private Long       profileKey   ;

    @Column(name="active_status", nullable=false, length=75)
    private String     activeStatus ;

    @Column(name="qualification", nullable=false, length=240)
    private String     qualification ;

    @Column(name="institutes", nullable=false, length=240)
    private String     institutes   ;

    @Column(name="state", nullable=false, length=240)
    private String     state        ;

    @Column(name="city", nullable=false, length=240)
    private String     city         ;

    @Column(name="country", nullable=false, length=240)
    private String     country      ;
    
    @Column(name="state_key", nullable=false, length=240)
    private Long     stateKey        ;

    @Column(name="city_key", nullable=false, length=240)
    private Long     cityKey         ;

    @Column(name="country_key", nullable=false, length=240)
    private Long     countryKey      ;
    
    @Transient
    private List<String> peiSpecialization;
    
    @Transient
    private List<Long> peiSpecializationKey;

    @Column(name="image_count")
    private Long imageCount;
    
    @Column(name="video_count")
    private Long videoCount;
    
    @Column(name="doc_count")
    private Long docCount;
    
    @Column(name="pei_qualification_status")
    private String  peiQualificationStatus;
    
    @Column(name="pei_edu_institute_status")
    private String  peiEduInstituteStatus;
    
    @Column(name="city_status")
    private String  cityStatus;
    
    @Column(name="state_status")
    private String  stateStatus;
    
    @Transient
    private Long otherSpecializationKey;
	
    @Transient
    private String otherSpecializationStatus;
	
    @Transient
	private String otherSpecializationName;
    
    @Column(name="pei_created_by",length=20)
    private Long peiCreatedBy;
    
    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

   

	//----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TIdEducationalInformationViewEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pei_key ( BIGINT ) 
    public void setPeiKey( Long peiKey ) {
        this.peiKey = peiKey;
    }
    public Long getPeiKey() {
        return this.peiKey;
    }

    //--- DATABASE MAPPING : pei_pin_key ( BIGINT ) 
    public void setPeiPinKey( Long peiPinKey ) {
        this.peiPinKey = peiPinKey;
    }
    public Long getPeiPinKey() {
        return this.peiPinKey;
    }

    //--- DATABASE MAPPING : pei_qualification_key ( BIGINT ) 
    public void setPeiQualificationKey( Long peiQualificationKey ) {
        this.peiQualificationKey = peiQualificationKey;
    }
    public Long getPeiQualificationKey() {
        return this.peiQualificationKey;
    }

    //--- DATABASE MAPPING : pei_edu_institute_key ( BIGINT ) 
    public void setPeiEduInstituteKey( Long peiEduInstituteKey ) {
        this.peiEduInstituteKey = peiEduInstituteKey;
    }
    public Long getPeiEduInstituteKey() {
        return this.peiEduInstituteKey;
    }

    //--- DATABASE MAPPING : pei_from_month ( VARCHAR ) 
    public void setPeiFromMonth( String peiFromMonth ) {
        this.peiFromMonth = peiFromMonth;
    }
    public String getPeiFromMonth() {
        return this.peiFromMonth;
    }

    //--- DATABASE MAPPING : pei_from_year ( BIGINT ) 
    public void setPeiFromYear( String peiFromYear ) {
        this.peiFromYear = peiFromYear;
    }
    public String getPeiFromYear() {
        return this.peiFromYear;
    }

    //--- DATABASE MAPPING : pei_to_month ( VARCHAR ) 
    public void setPeiToMonth( String peiToMonth ) {
        this.peiToMonth = peiToMonth;
    }
    public String getPeiToMonth() {
        return this.peiToMonth;
    }

    //--- DATABASE MAPPING : pei_to_year ( BIGINT ) 
    public void setPeiToYear( String peiToYear ) {
        this.peiToYear = peiToYear;
    }
    public String getPeiToYear() {
        return this.peiToYear;
    }

    //--- DATABASE MAPPING : pei_remarks ( VARCHAR ) 
    public void setPeiRemarks( String peiRemarks ) {
        this.peiRemarks = peiRemarks;
    }
    public String getPeiRemarks() {
        return this.peiRemarks;
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

    //--- DATABASE MAPPING : active_status ( VARCHAR ) 
    public void setActiveStatus( String activeStatus ) {
        this.activeStatus = activeStatus;
    }
    public String getActiveStatus() {
        return this.activeStatus;
    }

    //--- DATABASE MAPPING : qualification ( VARCHAR ) 
    public void setQualification( String qualification ) {
        this.qualification = qualification;
    }
    public String getQualification() {
        return this.qualification;
    }

    //--- DATABASE MAPPING : institutes ( VARCHAR ) 
    public void setInstitutes( String institutes ) {
        this.institutes = institutes;
    }
    public String getInstitutes() {
        return this.institutes;
    }

    //--- DATABASE MAPPING : state ( VARCHAR ) 
    public void setState( String state ) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    //--- DATABASE MAPPING : city ( VARCHAR ) 
    public void setCity( String city ) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }

    //--- DATABASE MAPPING : country ( VARCHAR ) 
    public void setCountry( String country ) {
        this.country = country;
    }
    public String getCountry() {
        return this.country;
    }
    
    public List<String> getPeiSpecialization() {
		return peiSpecialization;
	}

	public void setPeiSpecialization(List<String> peiSpecialization) {
		this.peiSpecialization = peiSpecialization;
	}
	
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------


	public List<Long> getPeiSpecializationKey() {
		return peiSpecializationKey;
	}

	public void setPeiSpecializationKey(List<Long> peiSpecializationKey) {
		this.peiSpecializationKey = peiSpecializationKey;
	}

	
	public Long getImageCount() {
		return imageCount;
	}

	public void setImageCount(Long imageCount) {
		this.imageCount = imageCount;
	}

	public Long getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(Long videoCount) {
		this.videoCount = videoCount;
	}

	public Long getDocCount() {
		return docCount;
	}

	public void setDocCount(Long docCount) {
		this.docCount = docCount;
	}
	
	public Long getStateKey() {
		return stateKey;
	}

	public void setStateKey(Long stateKey) {
		this.stateKey = stateKey;
	}

	public Long getCityKey() {
		return cityKey;
	}

	public void setCityKey(Long cityKey) {
		this.cityKey = cityKey;
	}

	public Long getCountryKey() {
		return countryKey;
	}

	public void setCountryKey(Long countryKey) {
		this.countryKey = countryKey;
	}
	
 	public String getPeiQualificationStatus() {
		return peiQualificationStatus;
	}

	public void setPeiQualificationStatus(String peiQualificationStatus) {
		this.peiQualificationStatus = peiQualificationStatus;
	}

	public String getPeiEduInstituteStatus() {
		return peiEduInstituteStatus;
	}

	public void setPeiEduInstituteStatus(String peiEduInstituteStatus) {
		this.peiEduInstituteStatus = peiEduInstituteStatus;
	}

	public String getCityStatus() {
		return cityStatus;
	}

	public void setCityStatus(String cityStatus) {
		this.cityStatus = cityStatus;
	}

	public String getStateStatus() {
		return stateStatus;
	}

	public void setStateStatus(String stateStatus) {
		this.stateStatus = stateStatus;
	}
	
	public Long getOtherSpecializationKey() {
		return otherSpecializationKey;
	}

	public void setOtherSpecializationKey(Long otherSpecializationKey) {
		this.otherSpecializationKey = otherSpecializationKey;
	}

	public String getOtherSpecializationStatus() {
		return otherSpecializationStatus;
	}

	public void setOtherSpecializationStatus(String otherSpecializationStatus) {
		this.otherSpecializationStatus = otherSpecializationStatus;
	}

	public String getOtherSpecializationName() {
		return otherSpecializationName;
	}

	public void setOtherSpecializationName(String otherSpecializationName) {
		this.otherSpecializationName = otherSpecializationName;
	}
	
	
	

	public Long getPeiCreatedBy() {
		return peiCreatedBy;
	}

	public void setPeiCreatedBy(Long peiCreatedBy) {
		this.peiCreatedBy = peiCreatedBy;
	}

	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append("]:"); 
        sb.append(peiKey);
        sb.append("|");
        sb.append(peiPinKey);
        sb.append("|");
        sb.append(peiQualificationKey);
        sb.append("|");
        sb.append(peiEduInstituteKey);
        sb.append("|");
        sb.append(peiFromMonth);
        sb.append("|");
        sb.append(peiFromYear);
        sb.append("|");
        sb.append(peiToMonth);
        sb.append("|");
        sb.append(peiToYear);
        sb.append("|");
        sb.append(peiRemarks);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(qualification);
        sb.append("|");
        sb.append(institutes);
        sb.append("|");
        sb.append(state);
        sb.append("|");
        sb.append(city);
        sb.append("|");
        sb.append(country);
        sb.append("|");
        sb.append(peiSpecialization);
        sb.append("|");
        sb.append(peiQualificationStatus);
        sb.append("|");
        sb.append(peiEduInstituteStatus);
        sb.append("|");
        sb.append(cityStatus);
        sb.append("|");
        sb.append(stateStatus);
        sb.append("|");
        sb.append(peiCreatedBy);
        return sb.toString(); 
    } 

}
