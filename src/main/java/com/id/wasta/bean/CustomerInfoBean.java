package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.id.wasta.bean.jpa.TIdLanguageInformationViewEntity;
import com.id.wasta.util.action.CommonConstants;

/**
 * @author sivachandra.k
 *
 */
public class CustomerInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long pinKey;
	private Long fromPinKey;
	private List<Long> listOfPinKey;
	private Long title;
	private String titleName;
	private String firstName;
	private String lastName;
	private String nickName;
	private String gender;
	boolean genderViewAccessFlag=true;
	private String emailId;
	boolean emailViewAccessFlag=true;
	private String mobile;
	boolean mobileViewAccessFlag=true;
	private String landLine;
	boolean landLineViewAccessFlag=true;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
	private Date dob;
	
	boolean dobViewAccessFlag=true;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = CommonConstants.APP_TIME_ZONE)
	private Date doa;
	
	boolean doaViewAccessFlag=true;
	private Long nationalityKey;
	boolean nationViewAccessFlag=true;
	private Long cityKey;
	private Long stateKey;
	private Long countryKey;
	private Long companyKey;
	private String otherCompanyName;
	private List<Long> listOfbusinessKey;
	private Long designKey;
	private String otherDesignName;
	private Long profileKey;
	private Long relationId;
	private Long roleKey;
	private String role;
	private String otherRoleName;
	private Long functionKey;
	private String otherFunctionName;
	private List<Long> listOfDegreeKey; 
	private String linkedIn;
	private String facebook;
	private String twitter;
	private String city;
	private String state;
	private String country;
	private String nationality;
	private List<TIdLanguageInformationViewEntity> language;
	private String otherLanguage;
	private String address;
	private String remarks;
	private boolean actualCust;
	private List<RelationShipInfoBean> listOfRelationship;
    private Long otherTitleKey;
    private String otherTitleName;
    private Long lockKey;
    private String otherIndustryName;
    private String otherEducationName;
    private String otherCityName;
    private String otherStateName;
    private String designName;
    private String functionName;
    private String companyName;
    private String relationship;
    public List<CustRelShipBean> custRelShipBeanList;
    private List<TIdProfileAddressDetailsView> listOfTIdProfileAddressDetailsView;
    private Long creatorPinKey;
    
	public String getDesignName() {
		return designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Long getTitle() {
		return title;
	}

	public void setTitle(Long title) {
		this.title = title;
	}
	
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getCityKey() {
		return cityKey;
	}

	public void setCityKey(Long cityKey) {
		this.cityKey = cityKey;
	}

	public Long getStateKey() {
		return stateKey;
	}

	public void setStateKey(Long stateKey) {
		this.stateKey = stateKey;
	}

	public Long getCountryKey() {
		return countryKey;
	}

	public void setCountryKey(Long countryKey) {
		this.countryKey = countryKey;
	}

	public Long getCompanyKey() {
		return companyKey;
	}

	public void setCompanyKey(Long companyKey) {
		this.companyKey = companyKey;
	}

	public List<Long> getListOfbusinessKey() {
		return listOfbusinessKey;
	}

	public void setListOfbusinessKey(List<Long> listOfbusinessKey) {
		this.listOfbusinessKey = listOfbusinessKey;
	}

	public Long getDesignKey() {
		return designKey;
	}

	public void setDesignKey(Long designKey) {
		this.designKey = designKey;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public Long getNationalityKey() {
		return nationalityKey;
	}

	public void setNationalityKey(Long nationalityKey) {
		this.nationalityKey = nationalityKey;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Date getDoa() {
		return doa;
	}

	public void setDoa(Date doa) {
		this.doa = doa;
	}
	
	public boolean isDobViewAccessFlag() {
		return dobViewAccessFlag;
	}

	public void setDobViewAccessFlag(boolean dobViewAccessFlag) {
		this.dobViewAccessFlag = dobViewAccessFlag;
	}

	public boolean isDoaViewAccessFlag() {
		return doaViewAccessFlag;
	}

	public void setDoaViewAccessFlag(boolean doaViewAccessFlag) {
		this.doaViewAccessFlag = doaViewAccessFlag;
	}
	
	public boolean isEmailViewAccessFlag() {
		return emailViewAccessFlag;
	}

	public void setEmailViewAccessFlag(boolean emailViewAccessFlag) {
		this.emailViewAccessFlag = emailViewAccessFlag;
	}

	public boolean isMobileViewAccessFlag() {
		return mobileViewAccessFlag;
	}

	public void setMobileViewAccessFlag(boolean mobileViewAccessFlag) {
		this.mobileViewAccessFlag = mobileViewAccessFlag;
	}

	public boolean isLandLineViewAccessFlag() {
		return landLineViewAccessFlag;
	}

	public void setLandLineViewAccessFlag(boolean landLineViewAccessFlag) {
		this.landLineViewAccessFlag = landLineViewAccessFlag;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<TIdLanguageInformationViewEntity> getLanguage() {
		return language;
	}

	public void setLanguage(List<TIdLanguageInformationViewEntity> language) {
		this.language = language;
	}
	
	public String getOtherLanguage() {
		return otherLanguage;
	}

	public void setOtherLanguage(String otherLanguage) {
		this.otherLanguage = otherLanguage;
	}

	public Long getPinKey() {
		return pinKey;
	}

	public void setPinKey(Long pinKey) {
		this.pinKey = pinKey;
	}
	
	public Long getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(Long roleKey) {
		this.roleKey = roleKey;
	}

	public Long getFunctionKey() {
		return functionKey;
	}

	public void setFunctionKey(Long functionKey) {
		this.functionKey = functionKey;
	}
	
	public List<Long> getListOfDegreeKey() {
		return listOfDegreeKey;
	}

	public void setListOfDegreeKey(List<Long> listOfDegreeKey) {
		this.listOfDegreeKey = listOfDegreeKey;
	}

	public boolean isActualCust() {
		return actualCust;
	}

	public void setActualCust(boolean actualCust) {
		this.actualCust = actualCust;
	}

	public List<RelationShipInfoBean> getListOfRelationship() {
		return listOfRelationship;
	}

	public void setListOfRelationship(List<RelationShipInfoBean> listOfRelationship) {
		this.listOfRelationship = listOfRelationship;
	}

	public Long getOtherTitleKey() {
		return otherTitleKey;
	}

	public void setOtherTitleKey(Long otherTitleKey) {
		this.otherTitleKey = otherTitleKey;
	}

	public String getOtherTitleName() {
		return otherTitleName;
	}

	public void setOtherTitleName(String otherTitleName) {
		this.otherTitleName = otherTitleName;
	}
	
	public Long getLockKey() {
		return lockKey;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}
	
	public String getOtherCompanyName() {
		return otherCompanyName;
	}

	public void setOtherCompanyName(String otherCompanyName) {
		this.otherCompanyName = otherCompanyName;
	}

	public String getOtherDesignName() {
		return otherDesignName;
	}

	public void setOtherDesignName(String otherDesignName) {
		this.otherDesignName = otherDesignName;
	}

	public String getOtherRoleName() {
		return otherRoleName;
	}

	public void setOtherRoleName(String otherRoleName) {
		this.otherRoleName = otherRoleName;
	}

	public String getOtherFunctionName() {
		return otherFunctionName;
	}

	public void setOtherFunctionName(String otherFunctionName) {
		this.otherFunctionName = otherFunctionName;
	}
	
	public List<CustRelShipBean> getCustRelShipBeanList() {
		return custRelShipBeanList;
	}

	public void setCustRelShipBeanList(List<CustRelShipBean> custRelShipBeanList) {
		this.custRelShipBeanList = custRelShipBeanList;
	}

	public List<TIdProfileAddressDetailsView> getListOfTIdProfileAddressDetailsView() {
		return listOfTIdProfileAddressDetailsView;
	}

	public void setListOfTIdProfileAddressDetailsView(
			List<TIdProfileAddressDetailsView> listOfTIdProfileAddressDetailsView) {
		this.listOfTIdProfileAddressDetailsView = listOfTIdProfileAddressDetailsView;
	}

	public String getOtherIndustryName() {
		return otherIndustryName;
	}

	public void setOtherIndustryName(String otherIndustryName) {
		this.otherIndustryName = otherIndustryName;
	}

	public String getOtherEducationName() {
		return otherEducationName;
	}

	public void setOtherEducationName(String otherEducationName) {
		this.otherEducationName = otherEducationName;
	}

	public String getOtherCityName() {
		return otherCityName;
	}

	public void setOtherCityName(String otherCityName) {
		this.otherCityName = otherCityName;
	}

	public String getOtherStateName() {
		return otherStateName;
	}

	public void setOtherStateName(String otherStateName) {
		this.otherStateName = otherStateName;
	}

	public Long getCreatorPinKey() {
		return creatorPinKey;
	}

	public void setCreatorPinKey(Long creatorPinKey) {
		this.creatorPinKey = creatorPinKey;
	}

	public boolean isGenderViewAccessFlag() {
		return genderViewAccessFlag;
	}

	public void setGenderViewAccessFlag(boolean genderViewAccessFlag) {
		this.genderViewAccessFlag = genderViewAccessFlag;
	}

	public boolean isNationViewAccessFlag() {
		return nationViewAccessFlag;
	}

	public void setNationViewAccessFlag(boolean nationViewAccessFlag) {
		this.nationViewAccessFlag = nationViewAccessFlag;
	}

	public List<Long> getListOfPinKey() {
		return listOfPinKey;
	}

	public void setListOfPinKey(List<Long> listOfPinKey) {
		this.listOfPinKey = listOfPinKey;
	}

	public Long getFromPinKey() {
		return fromPinKey;
	}

	public void setFromPinKey(Long fromPinKey) {
		this.fromPinKey = fromPinKey;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
