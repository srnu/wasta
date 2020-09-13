package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="t_id_common_addresses")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdCommonAddressesEntity.countAll", query="SELECT COUNT(x) FROM TIdCommonAddressesEntity x" )
} )
public class TIdCommonAddressesEntity implements Serializable{
	 
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="comm_address_key", nullable=false)	
    private long commAddressKey;
	
    @Column(name="comm_address", length=4000)
    private String commAddress;
    
	@Column(name="comm_door_number", length=25)
	private String commDoorNumber;
	
	@Column(name="comm_building_name", length=240)
	private String commBuildingName;
	
	@Column(name="comm_po_box_number", length=25)
	private String commPoBoxNumber;
	
	@Column(name="comm_po_box_name", length=240)
    private String commPoBoxName;
	
	@Column(name="comm_street_name", length=240)
	private String commStreetName;
	
	@Column(name="comm_landmark", length=240)
	private String commLandmark;
	
    @Column(name="comm_country_key")
	private Long commCountryKey;
	
    @Column(name="comm_state_key")
	private Long commStateKey;
	
    @Column(name="comm_city_key")
	private Long commCityKey;
    
	@Column(name="comm_zip_key")
	private Long commZipKey;
	
	@Column(name="comm_phone", length=240)
	private String commPhone;
	
	@Column(name="comm_mobile", length=25)
	private String commMobile;
	
	@Column(name="comm_email", length=240)
	private String commEmail;
	
	@Column(name="comm_secondary_mobile", length=25)
	private String commSecondaryMobile;
	
	@Column(name="comm_secondary_email", length=240)
	private String commSecondaryEmail;
	
	@Column(name="comm_fax", length=75)
	private String commFax;
	
	@Column(name="comm_map_access_code", length=240)
	private String commMapAccessCode;
	
	@Column(name="comm_latitude", length=50)
	private String commLatitude;
	
    @Column(name="comm_longitude", length=50)
	private String commLongitude;
	
    @Column(name="active_status", nullable=false, length=75)
	private String activeStatus;
	
	@Column(name="lock_key", nullable=false)
	@Version
	private Long lockKey;
	
    @Column(name="profile_key", nullable=false)
	private Long profileKey;
	
    public long getCommAddressKey() {
		return commAddressKey;
	}

	public void setCommAddressKey(long commAddressKey) {
		this.commAddressKey = commAddressKey;
	}

	public String getCommAddress() {
		return commAddress;
	}

	public void setCommAddress(String commAddress) {
		this.commAddress = commAddress;
	}

	public String getCommDoorNumber() {
		return commDoorNumber;
	}

	public void setCommDoorNumber(String commDoorNumber) {
		this.commDoorNumber = commDoorNumber;
	}

	public String getCommBuildingName() {
		return commBuildingName;
	}

	public void setCommBuildingName(String commBuildingName) {
		this.commBuildingName = commBuildingName;
	}

	public String getCommPoBoxNumber() {
		return commPoBoxNumber;
	}

	public void setCommPoBoxNumber(String commPoBoxNumber) {
		this.commPoBoxNumber = commPoBoxNumber;
	}

	public String getCommPoBoxName() {
		return commPoBoxName;
	}

	public void setCommPoBoxName(String commPoBoxName) {
		this.commPoBoxName = commPoBoxName;
	}

	public String getCommStreetName() {
		return commStreetName;
	}

	public void setCommStreetName(String commStreetName) {
		this.commStreetName = commStreetName;
	}

	public String getCommLandmark() {
		return commLandmark;
	}

	public void setCommLandmark(String commLandmark) {
		this.commLandmark = commLandmark;
	}

	public Long getCommCountryKey() {
		return commCountryKey;
	}

	public void setCommCountryKey(Long commCountryKey) {
		this.commCountryKey = commCountryKey;
	}

	public Long getCommStateKey() {
		return commStateKey;
	}

	public void setCommStateKey(Long commStateKey) {
		this.commStateKey = commStateKey;
	}

	public Long getCommCityKey() {
		return commCityKey;
	}

	public void setCommCityKey(Long commCityKey) {
		this.commCityKey = commCityKey;
	}

	public Long getCommZipKey() {
		return commZipKey;
	}

	public void setCommZipKey(Long commZipKey) {
		this.commZipKey = commZipKey;
	}

	public String getCommPhone() {
		return commPhone;
	}

	public void setCommPhone(String commPhone) {
		this.commPhone = commPhone;
	}

	public String getCommMobile() {
		return commMobile;
	}

	public void setCommMobile(String commMobile) {
		this.commMobile = commMobile;
	}

	public String getCommEmail() {
		return commEmail;
	}

	public void setCommEmail(String commEmail) {
		this.commEmail = commEmail;
	}

	public String getCommSecondaryMobile() {
		return commSecondaryMobile;
	}

	public void setCommSecondaryMobile(String commSecondaryMobile) {
		this.commSecondaryMobile = commSecondaryMobile;
	}

	public String getCommSecondaryEmail() {
		return commSecondaryEmail;
	}

	public void setCommSecondaryEmail(String commSecondaryEmail) {
		this.commSecondaryEmail = commSecondaryEmail;
	}

	public String getCommFax() {
		return commFax;
	}

	public void setCommFax(String commFax) {
		this.commFax = commFax;
	}

	public String getCommMapAccessCode() {
		return commMapAccessCode;
	}

	public void setCommMapAccessCode(String commMapAccessCode) {
		this.commMapAccessCode = commMapAccessCode;
	}

	public String getCommLatitude() {
		return commLatitude;
	}

	public void setCommLatitude(String commLatitude) {
		this.commLatitude = commLatitude;
	}

	public String getCommLongitude() {
		return commLongitude;
	}

	public void setCommLongitude(String commLongitude) {
		this.commLongitude = commLongitude;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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
	
	
	
}
