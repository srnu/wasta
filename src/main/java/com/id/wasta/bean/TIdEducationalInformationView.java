package com.id.wasta.bean;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TIdEducationalInformationView implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@NotNull
	private Long peiKey;

	@NotNull
	private Long peiPinKey;

	@NotNull
	private Long peiQualificationKey;

	@NotNull
	private Long peiEduInstituteKey;

	@Size(max = 3)
	private String peiFromMonth;

	private Long peiFromYear;

	@Size(max = 3)
	private String peiToMonth;

	private Long peiToYear;

	@Size(max = 1000)
	private String peiRemarks;

	@NotNull
	private Long lockKey;

	@NotNull
	private Long profileKey;

	@NotNull
	@Size(min = 1, max = 75)
	private String activeStatus;

	@NotNull
	@Size(min = 1, max = 240)
	private String qualification;

	@NotNull
	@Size(min = 1, max = 240)
	private String institutes;

	@NotNull
	@Size(min = 1, max = 240)
	private String state;

	@NotNull
	@Size(min = 1, max = 240)
	private String city;

	@NotNull
	@Size(min = 1, max = 240)
	private String country;

	private Long stateKey;

	private Long cityKey;

	private Long countryKey;

	@Size(min = 1, max = 240)
	private String peiSpecialization;
	
	private List<Long> peiSpecializationKey;

	private Long imageCount;

	private Long videoCount;

	private Long docCount;

	private boolean viewAccessFlag = true;
	
	
	 private String  peiQualificationStatus;
	 
	 private String  peiEduInstituteStatus;
	 
	 private String  cityStatus;
	 
	 private String  stateStatus;
	 
	 private Long otherSpecializationKey;
	 
	 private String otherSpecializationStatus;
	 
	 private String otherSpecializationName;
	
	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	public void setPeiKey(Long peiKey) {
		this.peiKey = peiKey;
	}

	public Long getPeiKey() {
		return this.peiKey;
	}

	public void setPeiPinKey(Long peiPinKey) {
		this.peiPinKey = peiPinKey;
	}

	public Long getPeiPinKey() {
		return this.peiPinKey;
	}

	public void setPeiQualificationKey(Long peiQualificationKey) {
		this.peiQualificationKey = peiQualificationKey;
	}

	public Long getPeiQualificationKey() {
		return this.peiQualificationKey;
	}

	public void setPeiEduInstituteKey(Long peiEduInstituteKey) {
		this.peiEduInstituteKey = peiEduInstituteKey;
	}

	public Long getPeiEduInstituteKey() {
		return this.peiEduInstituteKey;
	}

	public void setPeiFromMonth(String peiFromMonth) {
		this.peiFromMonth = peiFromMonth;
	}

	public String getPeiFromMonth() {
		return this.peiFromMonth;
	}

	public void setPeiFromYear(Long peiFromYear) {
		this.peiFromYear = peiFromYear;
	}

	public Long getPeiFromYear() {
		return this.peiFromYear;
	}

	public void setPeiToMonth(String peiToMonth) {
		this.peiToMonth = peiToMonth;
	}

	public String getPeiToMonth() {
		return this.peiToMonth;
	}

	public void setPeiToYear(Long peiToYear) {
		this.peiToYear = peiToYear;
	}

	public Long getPeiToYear() {
		return this.peiToYear;
	}

	public void setPeiRemarks(String peiRemarks) {
		this.peiRemarks = peiRemarks;
	}

	public String getPeiRemarks() {
		return this.peiRemarks;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public Long getLockKey() {
		return this.lockKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public Long getProfileKey() {
		return this.profileKey;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setInstitutes(String institutes) {
		this.institutes = institutes;
	}

	public String getInstitutes() {
		return this.institutes;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public String getPeiSpecialization() {
		return peiSpecialization;
	}

	public void setPeiSpecialization(String peiSpecialization) {
		this.peiSpecialization = peiSpecialization;
	}
	
	public List<Long> getPeiSpecializationKey() {
		return peiSpecializationKey;
	}

	public void setPeiSpecializationKey(List<Long> peiSpecializationKey) {
		this.peiSpecializationKey = peiSpecializationKey;
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
	
	public boolean isViewAccessFlag() {
		return viewAccessFlag;
	}

	public void setViewAccessFlag(boolean viewAccessFlag) {
		this.viewAccessFlag = viewAccessFlag;
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
	

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------

	

	

	public String toString() {
		StringBuffer sb = new StringBuffer();
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
        sb.append(otherSpecializationKey);
        sb.append("|");
        sb.append(otherSpecializationStatus);
        sb.append("|");
        sb.append(otherSpecializationName);
		return sb.toString();
	}

}
