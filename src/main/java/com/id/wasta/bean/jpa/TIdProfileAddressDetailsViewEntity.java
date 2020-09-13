package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="t_id_profile_address_details_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdProfileAddressDetailsViewEntity.countAll", query="SELECT COUNT(x) FROM TIdProfileAddressDetailsViewEntity x" )
} )
public class TIdProfileAddressDetailsViewEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="pad_key", nullable=false)
	private Long padKey;
	
	@Column(name="pad_pin_key", nullable=false)
	private Long padPinKey;
	
	@Column(name="pad_address_type", nullable=false)
	private Long padAddressType;
	
	@Column(name="pad_address_line1")
	private String padAddressLine1;
	
	@Column(name="pad_address_line2")
	private String padAddressLine2;
	
	@Column(name="pad_city_key")
	private Long padCityKey;
	
	@Column(name="pad_state_key")
	private Long padStateKey;
	
	@Column(name="pad_country_key")
	private Long padCountryKey;
	
	@Column(name="pad_pinzip")
	private String padPinzip;
	
	@Column(name="lock_key",nullable=false)
	private Long lockKey;
	
	@Column(name="profile_key", nullable=false)
	private Long profileKey;
	
	@Column(name="active_status", nullable=false)
	private String activeStatus;
	
	@Column(name="city_code")
	private String cityCode;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="state_code")
	private String stateCode;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="address_type_abbreviation")
	private String addressTypeAbbreviation;
	
	public TIdProfileAddressDetailsViewEntity() {
		super();
	}

	public Long getPadKey() {
		return padKey;
	}

	public void setPadKey(Long padKey) {
		this.padKey = padKey;
	}

	public Long getPadPinKey() {
		return padPinKey;
	}

	public void setPadPinKey(Long padPinKey) {
		this.padPinKey = padPinKey;
	}

	public Long getPadAddressType() {
		return padAddressType;
	}

	public void setPadAddressType(Long padAddressType) {
		this.padAddressType = padAddressType;
	}

	public String getPadAddressLine1() {
		return padAddressLine1;
	}

	public void setPadAddressLine1(String padAddressLine1) {
		this.padAddressLine1 = padAddressLine1;
	}

	public String getPadAddressLine2() {
		return padAddressLine2;
	}

	public void setPadAddressLine2(String padAddressLine2) {
		this.padAddressLine2 = padAddressLine2;
	}

	public Long getPadCityKey() {
		return padCityKey;
	}

	public void setPadCityKey(Long padCityKey) {
		this.padCityKey = padCityKey;
	}

	public Long getPadStateKey() {
		return padStateKey;
	}

	public void setPadStateKey(Long padStateKey) {
		this.padStateKey = padStateKey;
	}

	public Long getPadCountryKey() {
		return padCountryKey;
	}

	public void setPadCountryKey(Long padCountryKey) {
		this.padCountryKey = padCountryKey;
	}

	public String getPadPinzip() {
		return padPinzip;
	}

	public void setPadPinzip(String padPinzip) {
		this.padPinzip = padPinzip;
	}

	public Long getLockKey() {
		return lockKey;
	}

	public void setLockKey(Long lockKey) {
		this.lockKey = lockKey;
	}

	public Long getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getAddressTypeAbbreviation() {
		return addressTypeAbbreviation;
	}

	public void setAddressTypeAbbreviation(String addressTypeAbbreviation) {
		this.addressTypeAbbreviation = addressTypeAbbreviation;
	}

	public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(padKey);
        sb.append("|");
        sb.append(padPinKey);
        sb.append("|");
        sb.append(padAddressType);
        sb.append("|");
        sb.append(padAddressLine1);
        sb.append("|");
        sb.append(padAddressLine2);
        sb.append("|");
        sb.append(padCityKey);
        sb.append("|");
        sb.append(padStateKey);
        sb.append("|");
        sb.append(padCountryKey);
        sb.append("|");
        sb.append(padPinzip);
        sb.append("|");
        sb.append(activeStatus);
        sb.append("|");
        sb.append(lockKey);
        sb.append("|");
        sb.append(profileKey);
        sb.append("|");
        sb.append(cityCode);
        sb.append("|");
        sb.append(cityName);
        sb.append("|");
        sb.append(countryCode);
        sb.append("|");
        sb.append(countryName);
        sb.append("|");
        sb.append(stateCode);
        sb.append("|");
        sb.append(stateName);
        sb.append("|");
        sb.append(addressTypeAbbreviation);
        return sb.toString(); 
    } 
}
